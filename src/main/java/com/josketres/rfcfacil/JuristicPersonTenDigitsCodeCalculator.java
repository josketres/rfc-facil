package com.josketres.rfcfacil;

import java.util.Locale;

/**
 * Calculates the first ten digits of the RFC for a juristic person.
 */
public class JuristicPersonTenDigitsCodeCalculator {

    private final JuristicPerson person;

    public JuristicPersonTenDigitsCodeCalculator(JuristicPerson person) {
        this.person = person;
    }

    public String calculate() {

        String[] words = person.legalName.split("\\s");
        return "" + words[0].charAt(0) + words[1].charAt(0) + words[2].charAt(0) + "-" + birthdayCode();
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
