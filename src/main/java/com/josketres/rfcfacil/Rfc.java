package com.josketres.rfcfacil;

/**
 * Use Rfc.Builder to build instances of Rfc.
 */
public class Rfc {

    public final String homoclave;

    private Rfc(String homoclave) {

        this.homoclave = homoclave;
    }

    public static class Builder {

        private String name;
        private String firstLastName;
        private String secondLastName;
        private int day;
        private int month;
        private int year;

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

        public Rfc build() {

            Person person = new Person(name, firstLastName, secondLastName, day, month, year);
            String homoclave = new HomoclaveCalculator(person).calculate();

            return new Rfc(homoclave);
        }
    }
}
