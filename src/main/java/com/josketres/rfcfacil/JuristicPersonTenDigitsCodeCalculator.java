package com.josketres.rfcfacil;

import java8.util.stream.Stream;
import java8.util.stream.StreamSupport;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

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

    /*
    * This list is based on Anexo V from the official documentation
    * but some words have been commented out because the examples from
    * the same documentation contradict the list
    */
    public static final String[] FORBIDDEN_WORDS = {
            "EL", "LA", "DE", "LOS", "LAS", "Y", "DEL", "MI",
            "POR", "CON", /*"AL",*/ "SUS", "E", "PARA", "EN",
            "MC", "VON", "MAC", "VAN",
            "COMPANIA", "CIA", "CIA.",
            "SOCIEDAD", "SOC", "SOC.",
            "COMPANY", "CO",
            /*"COOPERATIVA", "COOP",*/
            "SC", "SCL", "SCS", "SNC", "SRL", "CV", "SA",
            "THE", "OF", "AND", "A",
    };

    private final JuristicPerson person;

    private String[] words;

    public JuristicPersonTenDigitsCodeCalculator(JuristicPerson person) {

        this.person = person;
    }

    public String calculate() {

        words = stream(person.legalName)
                .map(this::normalize)
                .map(this::ignoreJuristicPersonTypeAbbreviations)
                .flatMap(this::splitWords)
                .filter(this::ignoreForbiddenWords)
                .map(this::markOneLetterAbbreviations)
                .flatMap(this::expandSpecialCharactersInSingletonWord)
                .map(this::ignoreSpecialCharactersInWords)
                .flatMap(this::splitOneLetterAbbreviations)
                .flatMap(this::expandArabicNumerals)
                .flatMap(this::expandRomanNumerals)
                .toArray(String[]::new);

        return threeDigitsCode() + "-" + birthdayCode();
    }

    // to upper case, no leading nor trailing space,  and no accents
    private String normalize(String string) {

        if (StringUtils.isEmpty(string)) {
            return string;
        } else {
            return StringUtils.stripAccents(string)
                    .toUpperCase()
                    .trim();
        }
    }

    private String ignoreJuristicPersonTypeAbbreviations(String string) {

        return string.replaceAll(JURISTIC_PERSON_TYPE, "");
    }

    private Stream<String> splitWords(String string) {

        return stream(string.split("[, ]+"));
    }

    private boolean ignoreForbiddenWords(String word) {

        return stream(FORBIDDEN_WORDS).noneMatch(f -> word.equalsIgnoreCase(f));
    }

    private String markOneLetterAbbreviations(String word) {

        return word.replaceAll("^([^.])\\.", "$1AABBRREEVVIIAATTIIOONN");
    }


    private Stream<String> expandSpecialCharactersInSingletonWord(String word) {

        if (word.length() == 1) {
            return stream(word.replace("@", "ARROBA")
                    .replace("´", "APOSTROFE")
                    .replace("%", "PORCIENTO")
                    .replace("#", "NUMERO")
                    .replace("!", "ADMIRACION")
                    .replace(".", "PUNTO")
                    .replace("$", "PESOS")
                    .replace("\"", "COMILLAS")
                    .replace("-", "GUION")
                    .replace("/", "DIAGONAL")
                    .replace("+", "SUMA")
                    .replace("(", "ABRE PARENTESIS")
                    .replace(")", "CIERRA PARENTESIS")
                    .split(" "));
        }
        return stream(word);
    }

    private String ignoreSpecialCharactersInWords(String word) {

        return word.replaceAll("(.+?)[@´%#!.$\"-/+\\(\\)](.+?)", "$1$2");
    }


    private Stream<String> splitOneLetterAbbreviations(String w) {

        return stream(w.split("AABBRREEVVIIAATTIIOONN"));
    }

    private Stream<String> expandArabicNumerals(String word) {

        if (word.matches("[0-9]+")) {
            String number = normalize(SpanishNumbers.cardinal(Long.parseLong(word)));
            return stream(number.split(" "));
        } else {
            return stream(word);
        }
    }

    private Stream<String> expandRomanNumerals(String word) {

        if (RomanNumerals.isRomanNumeral(word)) {
            String number = normalize(SpanishNumbers.cardinal(RomanNumerals.parseInt(word)));
            return stream(number.split(" "));
        } else {
            return stream(word);
        }
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

    private static Stream<String> stream(String[] array) {

        return StreamSupport.stream(Arrays.asList(array));
    }

    private static Stream<String> stream(String string) {

        return StreamSupport.stream(Collections.singletonList(string));
    }
}
