package com.josketres.rfcfacil;

/**
 * Calculates the first ten digits of the RFC.
 */
class TenDigitsCodeCalculator {

    private final Person person;

    public TenDigitsCodeCalculator(Person person) {

        this.person = person;
    }

    public String calculate() {

        return person.name.charAt(0) + firstVowel();
    }

    private String firstVowel() {
        return "";
    }
}
