package com.josketres.rfcfacil;

class NaturalPerson implements HomoclavePerson {

    public final String name;
    public final String firstLastName;
    public final String secondLastName;
    public final int day;
    public final int month;
    public final int year;

    public NaturalPerson(String name, String firstLastName, String secondLastName, int day, int month, int year) {

        this.name = name;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String getFullNameForHomoclave() {
        return firstLastName + " " + secondLastName + " " + name;
    }
}
