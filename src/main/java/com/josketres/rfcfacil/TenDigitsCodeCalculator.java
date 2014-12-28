package com.josketres.rfcfacil;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Calculates the first ten digits of the RFC.
 */
class TenDigitsCodeCalculator {

    public static final Pattern VOWEL_PATTERN = Pattern.compile("[AEIOU]+");

    private final Person person;

    public static final String[] SPECIAL_PARTICLES =
            {"DE", "LA", "LAS", "MC", "VON", "DEL", "LOS", "Y", "MAC", "VAN", "MI"};

    public TenDigitsCodeCalculator(Person person) {

        this.person = person;
    }

    public String calculate() {

        return firstLetterOf(person.firstLastName)
                + firstVowelExcludingFirstCharacterOf(person.firstLastName)
                + firstLetterOf(person.secondLastName)
                + firstLetterOf(person.name)
                + " "
                + lastTwoDigitsOf(person.year)
                + formattedInTwoDigits(person.month)
                + formattedInTwoDigits(person.day);
    }

    private String formattedInTwoDigits(int number) {

        return String.format("%02d", number);
    }

    private String lastTwoDigitsOf(int number) {

        return number % 100 + "";
    }

    private String firstLetterOf(String word) {

        String normalizedWord = normalize(word);
        return normalizedWord.charAt(0) + "";
    }

    private String normalize(String word) {

        String normalizedWord = StringUtils.stripAccents(word).toUpperCase();
        return removeExcludedParticles(normalizedWord, SPECIAL_PARTICLES);
    }

    private String removeExcludedParticles(String word, String[] excludedParticles) {

        StringBuilder newWord = new StringBuilder(word);
        for (String particle : excludedParticles) {
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
            throw new IllegalArgumentException("Word doesn't contain a vowel: " + normalizedWord);
        }
        return normalizedWord.charAt(m.start()) + "";
    }
}
