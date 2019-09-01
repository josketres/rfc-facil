package com.josketres.rfcfacil;

import org.apache.commons.lang3.StringUtils;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Calculates the first ten digits of the RFC for a natural person.
 */
class NaturalPersonTenDigitsCodeCalculator {

    private static final Pattern VOWEL_PATTERN = Pattern.compile("[AEIOU]+");

    private final NaturalPerson person;

    private static final String[] SPECIAL_PARTICLES =
            {"DE", "LA", "LAS", "MC", "VON", "DEL", "LOS", "Y", "MAC", "VAN", "MI"};

    private static final String[] FORBIDDEN_WORDS = { "BUEI", "BUEY", "CACA", "CACO", "CAGA", "CAGO", "CAKA", "CAKO", "COGE", "COJA", "COJE", "COJI", "COJO", "CULO", "FETO", "GUEY", "JOTO", "KACA", "KACO", "KAGA", "KAGO", "KOGE", "KOJO", "KAKA", "KULO", "MAME", "MAMO", "MEAR", "MEAS", "MEON", "MION", "MOCO", "MULA", "PEDA", "PEDO", "PENE", "PUTA", "PUTO", "QULO", "RATA", "RUIN" };


    NaturalPersonTenDigitsCodeCalculator(NaturalPerson person) {

        this.person = person;
    }

    public String calculate() {

        return obfuscateForbiddenWords(nameCode()) + birthdayCode();
    }

    private String obfuscateForbiddenWords(String nameCode) {

        for (String forbidden : FORBIDDEN_WORDS) {
            if (forbidden.equals(nameCode)) {
                return nameCode.substring(0, 3) + "X";
            }
        }
        return nameCode;
    }

    private String nameCode() {

        if (isFirstLastNameEmpty()) {
            return firstLastNameEmptyForm();
        } else if (isSecondLastNameEmpty()) {
            return secondLastNameEmptyForm();
        } else if (isFirstLastNameIsTooShort()) {
            return firstLastNameTooShortForm();
        } else {
            return normalForm();
        }
    }

    private String secondLastNameEmptyForm() {

        return firstTwoLettersOf(person.firstLastName)
                + firstTwoLettersOf(filterName(person.name));
    }

    private String birthdayCode() {

        return lastTwoDigitsOf(person.year)
                + formattedInTwoDigits(person.month)
                + formattedInTwoDigits(person.day);
    }

    private boolean isSecondLastNameEmpty() {

        return StringUtils.isEmpty(normalize(person.secondLastName));
    }

    private String firstLastNameEmptyForm() {

        return firstTwoLettersOf(person.secondLastName)
                + firstTwoLettersOf(filterName(person.name));
    }

    private boolean isFirstLastNameEmpty() {

        return StringUtils.isEmpty(normalize(person.firstLastName));
    }

    private String firstLastNameTooShortForm() {

        return firstLetterOf(person.firstLastName)
                + firstLetterOf(person.secondLastName)
                + firstTwoLettersOf(filterName(person.name));
    }

    private String firstTwoLettersOf(String word) {

        String normalizedWord = normalize(word);
        return normalizedWord.substring(0, 2);
    }

    private boolean isFirstLastNameIsTooShort() {

        return normalize(person.firstLastName).length() <= 2;
    }

    private String normalForm() {

        return firstLetterOf(person.firstLastName)
                + firstVowelExcludingFirstCharacterOf(person.firstLastName)
                + firstLetterOf(person.secondLastName)
                + firstLetterOf(filterName(person.name));
    }

    private String filterName(String name) {

        return normalize(name)
                .trim()
                .replaceFirst("^(MA|MA.|MARIA|JOSE)\\s+", "");
    }

    private String formattedInTwoDigits(int number) {

        return String.format(Locale.getDefault(), "%02d", number);
    }

    private String lastTwoDigitsOf(int number) {

        return formattedInTwoDigits(number % 100);
    }

    private String firstLetterOf(String word) {

        String normalizedWord = normalize(word);
        return String.valueOf(normalizedWord.charAt(0));
    }

    private String normalize(String word) {

        if (StringUtils.isEmpty(word)) {
            return word;
        } else {
            String normalizedWord = StringUtils.stripAccents(word).toUpperCase();
            return removeSpecialParticles(normalizedWord, SPECIAL_PARTICLES);
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

    private String firstVowelExcludingFirstCharacterOf(String word) {

        String normalizedWord = normalize(word).substring(1);
        Matcher m = VOWEL_PATTERN.matcher(normalizedWord);
        if (!m.find()) {
            return "X";
        }
        return String.valueOf(normalizedWord.charAt(m.start()));
    }
}
