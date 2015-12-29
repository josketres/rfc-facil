package com.josketres.rfcfacil;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * Calculates the first ten digits of the RFC for a juristic person.
 */
public class JuristicPersonTenDigitsCodeCalculator {

    public static final String[] FORBIDDEN_SENTENCES = {
            "S. EN N.C.", "S. EN C.", "S. DE R.L.", "S. EN C. POR A.", "S.A. DE C.V.", "A. EN P.",
            "S.C.L.", "S.C.S.",
            "S.A.", "S.N.C.", "S.C.", "A.C."
    };
    public static final String[] FORBIDDEN_WORDS = {
            "A", "ANTE", "BAJO", "CABE", "CON", "CONTRA", "DE", "DESDE", "DURANTE", "EN", "ENTRE", "HACIA", "HASTA", "MEDIANTE", "PARA", "POR", "SEGUN", "SIN", "SO", "SOBRE", "TRAS", "VERSUS", "VIA",
            "EL", "LA", "LOS", "LAS",
            "UN", "UNA", "UNOS", "UNAS",
            "LO", "AL", "DEL",
            "Y",
            "COMPANIA", "CIA.",
            "SOCIEDAD", "SOC."
    };

    private final JuristicPerson person;

    public JuristicPersonTenDigitsCodeCalculator(JuristicPerson person) {
        this.person = person;
    }

    public String calculate() {

        String[] words = normalize(person.legalName).split(" ");
        words = ignoreWords(words, FORBIDDEN_WORDS);
        System.out.println(Arrays.toString(words));
        if (words.length >= 3) {
            return "" + words[0].charAt(0) + words[1].charAt(0) + words[2].charAt(0) + "-" + birthdayCode();
        } else if (words.length == 2) {
            return "" + words[0].charAt(0) + words[1].substring(0, 2) + "-" + birthdayCode();
        } else {
            return words[0].substring(0, 3) + "-" + birthdayCode();
        }

    }

    private String normalize(String word) {
        if (StringUtils.isEmpty(word)) {
            return word;
        } else {
            String normalizedWord = StringUtils.stripAccents(word).toUpperCase();
            return removeSpecialParticles(normalizedWord, FORBIDDEN_SENTENCES);
        }
    }

    private String removeSpecialParticles(String word, String[] specialParticles) {

        StringBuilder newWord = new StringBuilder(word);
        for (String particle : specialParticles) {
            String[] particlePositions = {particle + " ", " " + particle};
            for (String p : particlePositions)
                while (newWord.toString().contains(p)) {
                    int i = newWord.toString().indexOf(p);
                    newWord.delete(i, i + p.length());
                }
        }
        return newWord.toString();
    }

    private String[] ignoreWords(String[] words, String[] forbiddenWords) {

        List<String> filteredWords = new LinkedList<String>(Arrays.asList(words));
        ListIterator<String> it = filteredWords.listIterator();

        while (it.hasNext()) {
            if (isWordForbidden(it.next(), forbiddenWords)) {
                it.remove();
            }
        }

        return filteredWords.toArray(new String[0]);
    }

    private boolean isWordForbidden(String word, String[] forbiddenWords) {

        for (String ignoredWord : forbiddenWords) {
            if (word.equalsIgnoreCase(ignoredWord)) {
                return true;
            }
        }
        return false;
    }

    private String birthdayCode() {

        return lastTwoDigitsOf(person.year)
                + formattedInTwoDigits(person.month)
                + formattedInTwoDigits(person.day);
    }

    private String formattedInTwoDigits(int number) {

        return String.format(Locale.getDefault(), "%02d", number);
    }

    private String lastTwoDigitsOf(int number) {

        return formattedInTwoDigits(number % 100);
    }
}
