package com.josketres.rfcfacil;

/**
 * Use Rfc.Builder to build instances of Rfc.
 */
public class Rfc {

    public final String tenDigitsCode;
    public final String homoclave;
    public final String verificationDigit;

    private Rfc(String tenDigitsCode, String homoclave, String verificationDigit) {

        this.tenDigitsCode = tenDigitsCode;
        this.homoclave = homoclave;
        this.verificationDigit = verificationDigit;
    }

    @Override
    public String toString() {

        return tenDigitsCode + homoclave + verificationDigit;
    }

    public static class Builder {

        private String name;
        private String firstLastName;
        private String secondLastName;
        private int day;
        private int month;
        private int year;
        private String legalName;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder firstLastName(String firstLastName) {
            this.firstLastName = firstLastName;
            return this;
        }

        public Builder secondLastName(String secondLastName) {
            this.secondLastName = secondLastName;
            return this;
        }

        public Builder birthday(int day, int month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
            return this;
        }

        public Builder legalName(String legalName) {
            this.legalName = legalName;
            return this;
        }

        public Builder creationDate(int day, int month, int year) {
            return birthday(day, month, year);
        }

        public Rfc build() {
            if (legalName != null) {
                return buildForJuristicPerson();
            } else {
                return buildForNaturalPerson();
            }
        }

        private Rfc buildForJuristicPerson() {
            JuristicPerson person = new JuristicPerson(legalName, day, month, year);

            String tenDigitsCode = new JuristicPersonTenDigitsCodeCalculator(person).calculate();
            String homoclave = new HomoclaveCalculator(person).calculate();
            String verificationDigit = new VerificationDigitCalculator(tenDigitsCode + homoclave).calculate();

            return new Rfc(tenDigitsCode.trim(), homoclave, verificationDigit);
        }

        private Rfc buildForNaturalPerson() {

            NaturalPerson person = new NaturalPerson(name, firstLastName, secondLastName, day, month, year);

            String tenDigitsCode = new NaturalPersonTenDigitsCodeCalculator(person).calculate();
            String homoclave = new HomoclaveCalculator(person).calculate();
            String verificationDigit = new VerificationDigitCalculator(tenDigitsCode + homoclave).calculate();

            return new Rfc(tenDigitsCode, homoclave, verificationDigit);
        }
    }
}
