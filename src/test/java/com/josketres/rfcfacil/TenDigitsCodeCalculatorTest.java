package com.josketres.rfcfacil;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TenDigitsCodeCalculatorTest {

    @Test
    public void should_calculate_ten_digits_code_for_simple_test_case() {

        assertThat(tenDigitsCode("Juan", "Barrios", "Fernandez", 13, 12, 1970), equalTo("BAFJ701213"));
    }

    @Test
    public void should_calculate_ten_digits_code_for_date_after_year_2000() {

        assertThat(tenDigitsCode("Juan", "Barrios", "Fernandez", 1, 12, 2001), equalTo("BAFJ011201"));
    }

    @Test
    public void should_exclude_special_particles_in_both_last_names() {

        // DE, LA, LAS, MC, VON, DEL, LOS, Y, MAC, VAN, MI
        assertThat(tenDigitsCode("Eric", "Mc Gregor", "Von Juarez", 13, 12, 1970), equalTo("GEJE701213"));
    }

    @Test
    public void should_exclude_special_particles_in_the_first_last_name() {

        assertThat(tenDigitsCode("Josue", "Zarzosa", "de la Torre", 13, 12, 1970), equalTo("ZATJ701213"));
    }

    @Test
    public void should_exclude_special_particles_in_the_second_last_name() {

        assertThat(tenDigitsCode("Josue", "de la Torre", "Zarzosa", 13, 12, 1970), equalTo("TOZJ701213"));
    }

    @Test
    public void should_use_first_word_of_compound_second_last_name() {

        assertThat(tenDigitsCode("Antonio", "Jiménez", "Ponce de León", 13, 12, 1970), equalTo("JIPA701213"));
    }

    @Test
    public void should_use_first_word_of_compound_first_last_name() {

        assertThat(tenDigitsCode("Antonio", "Ponce de León", "Juarez", 13, 12, 1970), equalTo("POJA701213"));
    }

    @Test
    public void should_use_use_first_two_letters_of_first_name_if_first_last_name_has_just_one_letter() {

        assertThat(tenDigitsCode("Alvaro", "de la O", "Lozano", 13, 12, 1970), equalTo("OLAL701213"));
    }

    @Test
    public void should_use_use_first_two_letters_of_first_name_if_first_last_name_has_just_two_letters() {

        assertThat(tenDigitsCode("Ernesto", "Ek", "Rivera", 13, 12, 1970), equalTo("ERER701213"));
    }

    @Test
    public void should_use_first_name_if_person_has_multiple_names() {

        assertThat(tenDigitsCode("Luz María", "Fernández", "Juárez", 13, 12, 1970), equalTo("FEJL701213"));
    }

    @Test
    public void should_use_second_name_if_person_has_multiple_names_and_first_name_is_jose() {

        assertThat(tenDigitsCode("José Antonio", "Camargo", "Hernández", 13, 12, 1970), equalTo("CAHA701213"));
    }

    @Test
    public void should_use_second_name_if_person_has_multiple_names_and_first_name_is_maria() {

        assertThat(tenDigitsCode("María Luisa", "Ramírez", "Sánchez", 13, 12, 1970), equalTo("RASL701213"));
    }

    @Test
    public void should_use_first_two_letters_of_second_last_name_if_empty_first_last_name_is_provided() {

        assertThat(tenDigitsCode("Juan", "", "Martínez", 13, 12, 1970), equalTo("MAJU701213"));
    }

    @Test
    public void should_use_first_two_letters_of_second_last_name_if_null_first_last_name_is_provided() {

        assertThat(tenDigitsCode("Juan", null, "Martínez", 13, 12, 1970), equalTo("MAJU701213"));
    }

    @Test
    public void should_use_first_two_letters_of_first_last_name_if_empty_second_last_name_is_provided() {

        assertThat(tenDigitsCode("Gerarda", "Zafra", "", 13, 12, 1970), equalTo("ZAGE701213"));
    }

    @Test
    public void should_use_first_two_letters_of_first_last_name_if_null_second_last_name_is_provided() {

        assertThat(tenDigitsCode("Gerarda", "Zafra", null, 13, 12, 1970), equalTo("ZAGE701213"));
    }

    @Test
    public void should_replace_last_letter_with_X_if_code_makes_forbidden_word() {

        // BUEI -> BUEX
        assertThat(tenDigitsCode("Ingrid", "Bueno", "Ezquerra", 13, 12, 1970), equalTo("BUEX701213"));
    }

    private String tenDigitsCode(String name,
                                 String firstLastName,
                                 String secondLastName,
                                 int day, int month, int year) {

        return new TenDigitsCodeCalculator(new Person(name, firstLastName, secondLastName, day, month, year))
                .calculate();
    }
}
