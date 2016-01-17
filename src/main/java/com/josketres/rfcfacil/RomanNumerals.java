package com.josketres.rfcfacil;

import java.util.regex.Pattern;

// based on http://stackoverflow.com/questions/9073150/converting-roman-numerals-to-decimal
// TODO: unit-test the roman-numerals parsing
class RomanNumerals {

    private static Pattern ROMAN_NUMERAL =
            Pattern.compile("^(M{0,4})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");

    static boolean isRomanNumeral(String word) {
        return ROMAN_NUMERAL.matcher(word.trim()).matches();
    }

    static int parseInt(String number) {
        if (number.isEmpty()) return 0;
        if (number.startsWith("M")) return 1000 + parseInt(number.substring(1));
        if (number.startsWith("CM")) return 900 + parseInt(number.substring(2));
        if (number.startsWith("D")) return 500 + parseInt(number.substring(1));
        if (number.startsWith("CD")) return 400 + parseInt(number.substring(2));
        if (number.startsWith("C")) return 100 + parseInt(number.substring(1));
        if (number.startsWith("XC")) return 90 + parseInt(number.substring(2));
        if (number.startsWith("L")) return 50 + parseInt(number.substring(1));
        if (number.startsWith("XL")) return 40 + parseInt(number.substring(2));
        if (number.startsWith("X")) return 10 + parseInt(number.substring(1));
        if (number.startsWith("IX")) return 9 + parseInt(number.substring(2));
        if (number.startsWith("V")) return 5 + parseInt(number.substring(1));
        if (number.startsWith("IV")) return 4 + parseInt(number.substring(2));
        if (number.startsWith("I")) return 1 + parseInt(number.substring(1));
        throw new IllegalArgumentException("no roman numeral recognized");
    }
}
