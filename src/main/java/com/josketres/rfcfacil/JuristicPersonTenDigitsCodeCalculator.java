package com.josketres.rfcfacil;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Calculates the first ten digits of the RFC for a juristic person.
 */
public class JuristicPersonTenDigitsCodeCalculator {

    public static final String JURISTIC_PERSON_TYPE = " (S\\.? EN N\\.?C\\.?|" +
            "S\\.? EN C\\.? POR A\\.?|" +
            "S\\.? EN C\\.?|" +
            "S\\.? DE R\\.?L\\.?|" +
            "S\\.?A\\.? DE C\\.?V\\.?|" +
            "A\\.? EN P\\.?|" +
            "S\\.?C\\.?[LS]\\.?|" +
            "S\\.?[AC]\\.?|" +
            "S\\.?N\\.?C\\.?|" +
            "A\\.?C\\.?)$";

    public static final String[] FORBIDDEN_WORDS = {
            "A", "ANTE", "BAJO", "CABE", "CON", "CONTRA", "DE", "DESDE",
            "DURANTE", "EN", "ENTRE", "HACIA", "HASTA", "MEDIANTE", "PARA",
            "POR", "SEGUN", "SIN", "SO", "SOBRE", "TRAS", "VERSUS", "VIA",
            "EL", "LA", "LOS", "LAS",
            "UN", "UNA", "UNOS", "UNAS",
            "LO", /*"AL",*/ "DEL",
            "Y",
            "COMPANIA", "CIA.",
            "SOCIEDAD", "SOC."
    };

    private final JuristicPerson person;

    private String normalizedPersonLegalName;
    private String[] words;

    public JuristicPersonTenDigitsCodeCalculator(JuristicPerson person) {

        this.person = person;
    }

    public String calculate() {

        normalizePersonLegalName();
        ignoreJuristicPersonTypeAbbreviations();
        splitInWords();
        ignoreForbiddenWords();
        splitAbbreviations();
        convertNumeralsToWords();
        return threeDigitsCode() + "-" + birthdayCode();
    }

    private void normalizePersonLegalName() {

        normalizedPersonLegalName = normalize(person.legalName);
    }

    // to upper case, no leading nor trailing space,  and no accents
    private String normalize(String word) {

        if (StringUtils.isEmpty(word)) {
            return word;
        } else {
            return StringUtils.stripAccents(word)
                    .toUpperCase()
                    .trim();
        }
    }

    private void ignoreJuristicPersonTypeAbbreviations() {

        normalizedPersonLegalName = normalizedPersonLegalName.replaceAll(JURISTIC_PERSON_TYPE, "");
    }

    private void splitInWords() {

        words = normalizedPersonLegalName.split("[, ]+");
    }

    private void ignoreForbiddenWords() {

        words = Arrays.asList(words).stream()
                .filter(w -> !isWordForbidden(w, FORBIDDEN_WORDS))
                .toArray(String[]::new);
    }

    private boolean isWordForbidden(String word, String[] forbiddenWords) {

        for (String ignoredWord : forbiddenWords) {
            if (word.equalsIgnoreCase(ignoredWord)) {
                return true;
            }
        }
        return false;
    }

    private void splitAbbreviations() {

        words = StringUtils.join(words, " ").split("[\\. ]+");
    }

    private void convertNumeralsToWords() {

        if (!Pattern.compile("[0-9]").matcher(StringUtils.join(words)).find()) {
            return;
        }

        List<String> convertedWords = new LinkedList<String>(Arrays.asList(words));
        ListIterator<String> it = convertedWords.listIterator();
        while (it.hasNext()) {
            String word = it.next();
            if (word.matches("[0-9]+")) {
                it.remove();
                String number = normalize(SpanishNumbers.cardinal(Long.parseLong(word)));
                for (String numberWord : number.split(" ")) {
                    it.add(numberWord);
                }
            }
        }

        words = convertedWords.toArray(new String[0]);
    }

    private String threeDigitsCode() {

        if (words.length >= 3) {
            return "" + words[0].charAt(0) + words[1].charAt(0) + words[2].charAt(0);
        } else if (words.length == 2) {
            return "" + words[0].charAt(0) + words[1].substring(0, 2);
        } else {
            return firstThreeCharactersWithRightPad(words[0]);
        }
    }

    private String firstThreeCharactersWithRightPad(String word) {

        if (word.length() >= 3) {
            return word.substring(0, 3);
        }
        return StringUtils.rightPad(word, 3, "X");
    }

    private String birthdayCode() {

        return lastTwoDigitsOf(person.year)
                + formattedInTwoDigits(person.month)
                + formattedInTwoDigits(person.day);
    }

    private String formattedInTwoDigits(int number) {

        return String.format(Locale.ENGLISH, "%02d", number);
    }

    private String lastTwoDigitsOf(int number) {

        return formattedInTwoDigits(number % 100);
    }
}
