package com.josketres.rfcfacil;

import java.util.HashMap;
import java.util.Map;

/**
 * Calculates the last digit of the RFC.
 * Also known as "Digito Verificador".
 */
class VerificationDigitCalculator {

    private final String rfc12Digits;
    private static final Map<String, Integer> MAPPING = new HashMap<String, Integer>();

    static {
        MAPPING.put("0", 0);
        MAPPING.put("1", 1);
        MAPPING.put("2", 2);
        MAPPING.put("3", 3);
        MAPPING.put("4", 4);
        MAPPING.put("5", 5);
        MAPPING.put("6", 6);
        MAPPING.put("7", 7);
        MAPPING.put("8", 8);
        MAPPING.put("9", 9);
        MAPPING.put("A", 10);
        MAPPING.put("B", 11);
        MAPPING.put("C", 12);
        MAPPING.put("D", 13);
        MAPPING.put("E", 14);
        MAPPING.put("F", 15);
        MAPPING.put("G", 16);
        MAPPING.put("H", 17);
        MAPPING.put("I", 18);
        MAPPING.put("J", 19);
        MAPPING.put("K", 20);
        MAPPING.put("L", 21);
        MAPPING.put("M", 22);
        MAPPING.put("N", 23);
        MAPPING.put("&", 24);
        MAPPING.put("O", 25);
        MAPPING.put("P", 26);
        MAPPING.put("Q", 27);
        MAPPING.put("R", 28);
        MAPPING.put("S", 29);
        MAPPING.put("T", 30);
        MAPPING.put("U", 31);
        MAPPING.put("V", 32);
        MAPPING.put("W", 33);
        MAPPING.put("X", 34);
        MAPPING.put("Y", 35);
        MAPPING.put("Z", 36);
        MAPPING.put(" ", 37);
        MAPPING.put("Ñ", 38);
    }

    public VerificationDigitCalculator(String rfc12Digits) {

        this.rfc12Digits = rfc12Digits;
    }

    public String calculate() {

        int sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += mapDigit(rfc12Digits.charAt(i)) * (13 - i);
        }

        int reminder = sum % 11;
        if (reminder == 0) {
            return "0";
        } else if (reminder == 1) {
            return "A";
        } else {
            return String.valueOf(11 - reminder); // 1 - 9
        }
    }

    private int mapDigit(char c) {

        String key = String.valueOf(c);
        if (!MAPPING.containsKey(key)) {
            return 0;
        } else {
            return MAPPING.get(key);
        }
    }
}
