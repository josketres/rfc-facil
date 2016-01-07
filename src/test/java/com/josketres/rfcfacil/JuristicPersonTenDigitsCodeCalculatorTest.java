package com.josketres.rfcfacil;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class JuristicPersonTenDigitsCodeCalculatorTest {

    // rule 1
    @Test
    public void should_take_first_letters_from_the_first_three_words_from_legal_name() {

        assertThat(tenDigitsCode("Sonora Industrial Azucarera, S. de R.L.", 29, 11, 1982), startsWith("SIA"));
    }

    // rule 2
    @Test
    public void should_take_creation_date_in_format_yy_mm_dd() {

        assertThat(tenDigitsCode("Sonora Industrial Azucarera, S. de R.L.", 29, 11, 1982), equalTo("SIA-821129"));
    }

    // rule 2 part 2
    @Test
    public void should_prepend_zero_to_one_digit_numbers_in_creation_date() {

        assertThat(tenDigitsCode("Sonora Industrial Azucarera, S. de R.L.", 05, 02, 1983), endsWith("830205"));
        assertThat(tenDigitsCode("Sonora Industrial Azucarera, S. de R.L.", 05, 12, 1983), endsWith("831205"));
        assertThat(tenDigitsCode("Sonora Industrial Azucarera, S. de R.L.", 15, 02, 1983), endsWith("830215"));
    }

    // no test for rule 3


    // rule 4
    @Test
    public void should_consider_abreviations_as_if_they_where_words() {

        assertThat(tenDigitsCode("F.A.Z., S.A.", 29, 11, 1982), startsWith("FAZ"));
        assertThat(tenDigitsCode("U.S. Ruber Mexicana, S.A.", 29, 11, 1982), startsWith("USR"));
        assertThat(tenDigitsCode("H. Prieto y Martínez, S. de R.L.", 29, 11, 1982), startsWith("HPM"));
    }

    // rule 5
    @Test
    public void should_ignore_common_juristic_person_type_abbreviations() {

        assertThat(tenDigitsCode("Guantes Industriales Guadalupe, S. en C.", 29, 11, 1982), startsWith("GIG"));
        assertThat(tenDigitsCode("Construcciones Metálicas Mexicanas, S.A.", 29, 11, 1982), startsWith("CMM"));
        assertThat(tenDigitsCode("Fundición de Precisión Eutectic, S. de R.L.", 29, 11, 1982), startsWith("FPE"));
    }

    // rule 5
    @Test
    public void should_ignore_abbreviation_SA_DE_CV() {

        assertThat(tenDigitsCode("Guantes Industriales, S.A. de C.V.", 29, 11, 1982), startsWith("GIN"));
        assertThat(tenDigitsCode("Guantes Industriales, SA de CV", 29, 11, 1982), startsWith("GIN"));
    }

    // rule 5
    @Test
    public void should_ignore_abbreviation_SCL() {

        assertThat(tenDigitsCode("Guantes Industriales, S.C.L.", 29, 11, 1982), startsWith("GIN"));
        assertThat(tenDigitsCode("Guantes Industriales, SCL", 29, 11, 1982), startsWith("GIN"));
    }

    // rule 5
    @Test
    public void should_ignore_all_juristic_person_type_abreviations() {

        assertThat(tenDigitsCode("Guantes Industriales, S.C.L.", 29, 11, 1982), startsWith("GIN"));
        assertThat(tenDigitsCode("Guantes Industriales, SCL", 29, 11, 1982), startsWith("GIN"));
        assertThat(tenDigitsCode("Guantes Industriales, S. en C.", 29, 11, 1982), startsWith("GIN"));
        assertThat(tenDigitsCode("Guantes Industriales, S en C", 29, 11, 1982), startsWith("GIN"));
        assertThat(tenDigitsCode("Guantes Industriales, S. en C. por A.", 29, 11, 1982), startsWith("GIN"));
        assertThat(tenDigitsCode("Guantes Industriales, S en C por A", 29, 11, 1982), startsWith("GIN"));
        assertThat(tenDigitsCode("Guantes Industriales, S.A.", 29, 11, 1982), startsWith("GIN"));
        assertThat(tenDigitsCode("Guantes Industriales, SA", 29, 11, 1982), startsWith("GIN"));
        assertThat(tenDigitsCode("Guantes Industriales, S.C.", 29, 11, 1982), startsWith("GIN"));
        assertThat(tenDigitsCode("Guantes Industriales, SC", 29, 11, 1982), startsWith("GIN"));
        assertThat(tenDigitsCode("Guantes Industriales, S.A. de C.V.", 29, 11, 1982), startsWith("GIN"));
        assertThat(tenDigitsCode("Guantes Industriales, SA de CV", 29, 11, 1982), startsWith("GIN"));
        assertThat(tenDigitsCode("Guantes Industriales, S. de R.L.", 29, 11, 1982), startsWith("GIN"));
        assertThat(tenDigitsCode("Guantes Industriales, S de RL", 29, 11, 1982), startsWith("GIN"));
        assertThat(tenDigitsCode("Guantes Industriales, S. en N.C.", 29, 11, 1982), startsWith("GIN"));
        assertThat(tenDigitsCode("Guantes Industriales, S en NC", 29, 11, 1982), startsWith("GIN"));
        assertThat(tenDigitsCode("Guantes Industriales, S.N.C.", 29, 11, 1982), startsWith("GIN"));
        assertThat(tenDigitsCode("Guantes Industriales, SNC", 29, 11, 1982), startsWith("GIN"));
        assertThat(tenDigitsCode("Guantes Industriales, A.C.", 29, 11, 1982), startsWith("GIN"));
        assertThat(tenDigitsCode("Guantes Industriales, AC", 29, 11, 1982), startsWith("GIN"));
        assertThat(tenDigitsCode("Guantes Industriales, A. en P.", 29, 11, 1982), startsWith("GIN"));
        assertThat(tenDigitsCode("Guantes Industriales, A en P", 29, 11, 1982), startsWith("GIN"));
        assertThat(tenDigitsCode("Guantes Industriales, S.C.S.", 29, 11, 1982), startsWith("GIN"));
        assertThat(tenDigitsCode("Guantes Industriales, SCS", 29, 11, 1982), startsWith("GIN"));
    }

    // rule 6
    @Test
    public void should_use_first_and_second_letters_of_second_word_if_only_two_words_are_elegible() {

        assertThat(tenDigitsCode("Aceros Ecatepec, S.A.", 29, 11, 1982), startsWith("AEC"));
        assertThat(tenDigitsCode("Fonograbaciones Cinelandia, S. de R.L.", 29, 11, 1982), startsWith("FCI"));
        assertThat(tenDigitsCode("Distribuidora Ges, S.A. ", 29, 11, 1982), startsWith("DGE"));
    }

    // rule 7
    @Test
    public void should_use_first_three_letters_of_first_word_if_only_one_word_is_elegible() {

        assertThat(tenDigitsCode("Arsuyama, S.A.", 29, 11, 1982), startsWith("ARS"));
        assertThat(tenDigitsCode("Calidra, S.A.", 29, 11, 1982), startsWith("CAL"));
        assertThat(tenDigitsCode("Electrólisis, S.A.", 29, 11, 1982), startsWith("ELE"));
    }

    // rule 8
    @Test
    public void should_fill_with_character_X_if_only_one_word_is_elegible_and_is_smaller_than_3_characters_long() {

        // NOTE: the word Al should actually be filtered out as for the rule #9
        assertThat(tenDigitsCode("Al, S.A.", 29, 11, 1982), startsWith("ALX"));
        assertThat(tenDigitsCode("Z, S.A.", 29, 11, 1982), startsWith("ZXX"));
    }

    // rule 9
    @Test
    public void should_ignore_articles_prepositions_conjunctions_and_contractions() {

        assertThat(tenDigitsCode("El abastecedor Ferretero Electrico, S.A.", 29, 11, 1982), startsWith("AFE"));
        assertThat(tenDigitsCode("Cigarros la Tabacalera Mexicana, S.A. de C.V.", 29, 11, 1982), startsWith("CTM"));
        assertThat(tenDigitsCode("Los Viajes Internacionales de Marco Polo, S.A.", 29, 11, 1982), startsWith("VIM"));
        assertThat(tenDigitsCode("Artículos y Accesorios para Automóviles, S.A.", 29, 11, 1982), startsWith("AAA"));
        assertThat(tenDigitsCode("Productos de la Industria del Papel, S.A.", 29, 11, 1982), startsWith("PIP"));
    }

    // rule 10 - part 1 (arabic numerals)
    @Test
    public void should_translate_arabic_numerals_and_treat_them_as_words() {

        assertThat(tenDigitsCode("El 12, S.A.", 29, 11, 1982), startsWith("DOC"));
        assertThat(tenDigitsCode("El 2 de Enero, S. de R.L.", 29, 11, 1982), startsWith("DEN"));
        assertThat(tenDigitsCode("El 505, S.A.", 29, 11, 1982), startsWith("QCI"));
    }

    // rule 11
    @Test
    public void should_ignore_the_word_compania_and_its_abbreviation() {

        assertThat(tenDigitsCode("Compañía Periodística Nacional Electrica, S.A.", 29, 11, 1982), startsWith("PNE"));
        assertThat(tenDigitsCode("Cía. De Artículos Nacionales Eléctricos, S. de R.L.", 29, 11, 1982), startsWith("ANE"));
        assertThat(tenDigitsCode("Cía. Nal. De Subsistencias Mexicanas, S.A.", 29, 11, 1982), startsWith("NSM"));
    }

    // rule 11
    @Test
    public void should_ignore_the_word_sociedad_and_its_abbreviation() {

        assertThat(tenDigitsCode("Sociedad Cooperativa de Producción Agrícola de Michoacán", 29, 11, 1982), startsWith("CPA"));
        assertThat(tenDigitsCode("Soc. de Consumo Agrícola del Sur, S.C.L. ", 29, 11, 1982), startsWith("CAS"));
    }


    private String tenDigitsCode(String legalName, int day, int month, int year) {

        return new JuristicPersonTenDigitsCodeCalculator(new JuristicPerson(legalName, day, month, year)).calculate();
    }
}