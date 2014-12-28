package com.josketres.rfcfacil;

/**
 * Calculates the first twelve digits of the RFC.
 */
class FirstTwelveDigitsCalculator {

    private final Person person;

    public FirstTwelveDigitsCalculator(Person person) {

        this.person = person;
    }

    public String calculate() {

        return person.name.charAt(0) + firstVowel();
    }

    private String firstVowel() {
        return "";
    }
}
