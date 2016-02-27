package com.josketres.rfcfacil;

class JuristicPerson implements HomoclavePerson {

    public final String legalName;
    public final int day;
    public final int month;
    public final int year;

    public JuristicPerson(String legalName, int day, int month, int year) {

        this.legalName = legalName;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String getFullNameForHomoclave() {
        return legalName;
    }
}
