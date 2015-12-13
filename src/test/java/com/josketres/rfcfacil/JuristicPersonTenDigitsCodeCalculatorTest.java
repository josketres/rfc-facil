package com.josketres.rfcfacil;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.startsWith;

public class JuristicPersonTenDigitsCodeCalculatorTest {

    // rule 1
    @Test
    public void should_take_first_letters_from_the_first_three_words_from_legal_name() {

        assertThat(tenDigitsCode("Sonora Industrial Azucarera, S. de. R.L.", 29, 11, 1982), startsWith("SIA"));
    }

    // rule 2
    @Test
    public void should_take_creation_date_in_format_yy_mm_dd() {

        assertThat(tenDigitsCode("Sonora Industrial Azucarera, S. de. R.L.", 29, 11, 1982), equalTo("SIA-821129"));
    }

    private String tenDigitsCode(String legalName,
                                 int day, int month, int year) {

        return new JuristicPersonTenDigitsCodeCalculator(new JuristicPerson(legalName, day, month, year)).calculate();
    }
}