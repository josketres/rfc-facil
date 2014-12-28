package com.josketres.rfcfacil;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TenDigitsCodeCalculatorTest {

    @Test
    public void should_calculate_ten_digits_code_for_simple_test_case() {

        assertThat(tenDigitsCode("Juan", "Barrios", "Fernandez", 13, 12, 1970), equalTo("BAFJ 701213"));
    }

    @Test
    public void should_calculate_ten_digits_code_for_date_with_one_digit_day() {

        assertThat(tenDigitsCode("Juan", "Barrios", "Fernandez", 1, 12, 1970), equalTo("BAFJ 701201"));
    }

    @Test
    public void should_exclude_special_particles_in_both_last_names() {

        // DE, LA, LAS, MC, VON, DEL, LOS, Y, MAC, VAN, MI
        assertThat(tenDigitsCode("Eric", "Mc Gregor", "Von Juarez", 13, 12, 1970), equalTo("GEJE 701213"));
    }

    @Test
    public void should_exclude_special_particles_in_the_first_last_name() {

        assertThat(tenDigitsCode("Josue", "Zarzosa", "de la Torre", 13, 12, 1970), equalTo("ZATJ 701213"));
    }

    @Test
    public void should_exclude_special_particles_in_the_second_last_name() {

        assertThat(tenDigitsCode("Josue", "de la Torre", "Zarzosa", 13, 12, 1970), equalTo("TOZJ 701213"));
    }

    @Test
    public void should_use_first_word_of_compound_second_last_name() {

        assertThat(tenDigitsCode("Antonio", "Jiménez", "Ponce de León", 13, 12, 1970), equalTo("JIPA 701213"));
    }

    @Test
    public void should_use_first_word_of_compound_first_last_name() {

        assertThat(tenDigitsCode("Antonio", "Ponce de León", "Juarez", 13, 12, 1970), equalTo("POJA 701213"));
    }

    private String tenDigitsCode(String name,
                                 String firstLastName,
                                 String secondLastName,
                                 int day, int month, int year) {

        return new TenDigitsCodeCalculator(new Person(name, firstLastName, secondLastName, day, month, year))
                .calculate();
    }
}
