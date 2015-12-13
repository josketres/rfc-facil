package com.josketres.rfcfacil;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class HomoclaveCalculatorTest {

    @Test
    public void should_calculate_homoclave_for_simple_test_case() {

        assertThat(homoclave("Juan", "Perez", "Garcia"), equalTo("LN"));
    }

    @Test
    public void should_calculate_same_homoclave_for_names_with_and_without_accents() {

        assertThat(homoclave("Juan", "Perez", "Garcia"),
                equalTo(homoclave("Juan", "Pérez", "García")));
    }

    @Test
    public void should_calculate_homoclave_for_person_with_more_than_one_name() {

        assertThat(homoclave("Jose Antonio", "Del real", "Anzures"), equalTo("N9"));
    }

    @Test
    public void should_calculate_homoclave_for_name_with_n_with_tilde() {

        assertThat(homoclave("Juan", "Muñoz", "Ortega"), equalTo("T6"));
    }

    @Test
    public void should_calculate_homoclave_for_name_with_multiple_n_with_tilde() {

        assertThat(homoclave("Juan", "Muñoz", "Muñoz"), equalTo("RZ"));
    }

    @Test
    public void should_calculate_different_homoclave_for_name_with_n_with_tilde_and_without() {

        assertThat(homoclave("Juan", "Muñoz", "Ortega"),
                not(equalTo(homoclave("Juan", "Munoz", "Ortega"))));
    }

    @Test
    public void should_calculate_homoclave_for_name_with_u_with_umlaut() {

        assertThat(homoclave("Jesus", "Argüelles", "Ortega"), equalTo("JF"));
    }

    @Test
    public void should_calculate_same_homoclave_for_name_with_u_with_umlaut_and_without() {

        assertThat(homoclave("Jesus", "Argüelles", "Ortega"),
                equalTo(homoclave("Jesus", "Arguelles", "Ortega")));
    }

    @Test
    public void should_calculate_homoclave_for_name_with_ampersand() {

        assertThat(homoclave("Juan", "Perez&Gomez", "Garcia"), equalTo("2R"));
    }

    @Test
    public void should_calculate_same_homoclave_for_name_with_and_without_special_characters() {

        assertThat(homoclave("Juan", "Mc.Gregor", "O'Connor-Juarez"),
                equalTo(homoclave("Juan", "McGregor", "OConnorJuarez")));
    }

    @Test
    public void should_calculate_different_homoclave_for_names_with_and_without_ampersand() {

        assertThat(homoclave("Juan", "Perez&Gomez", "Garcia"),
                not(equalTo(homoclave("Juan", "PerezGomez", "Garcia"))));
    }

    @Test
    public void should_calculate_same_homoclave_for_different_birthdays() {

        assertThat(new HomoclaveCalculator(
                        new NaturalPerson("Juan", "Perez", "Garcia", 1, 1, 1901)).calculate(),
                equalTo(new HomoclaveCalculator(
                        new NaturalPerson("Juan", "Perez", "Garcia", 5, 8, 1987)).calculate()));
    }

    private String homoclave(String name, String firstLastName, String secondLastName) {

        return new HomoclaveCalculator(
                new NaturalPerson(name, firstLastName, secondLastName, 1, 1, 1901)).calculate();
    }

}
