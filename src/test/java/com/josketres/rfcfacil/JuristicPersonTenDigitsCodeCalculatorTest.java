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

    // rule 9
    @Test
    public void should_ignore_articles_prepositions_conjunctions_and_contractions() {

        assertThat(tenDigitsCode("El abastecedor Ferretero Electrico, S.A.", 29, 11, 1982), startsWith("AFE"));
        assertThat(tenDigitsCode("Cigarros la Tabacalera Mexicana, S.A. de C.V.", 29, 11, 1982), startsWith("CTM"));
        assertThat(tenDigitsCode("Los Viajes Internacionales de Marco Polo, S.A.", 29, 11, 1982), startsWith("VIM"));
        assertThat(tenDigitsCode("Artículos y Accesorios para Automóviles, S.A.", 29, 11, 1982), startsWith("AAA"));
        assertThat(tenDigitsCode("Productos de la Industria del Papel, S.A.", 29, 11, 1982), startsWith("PIP"));
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

    // rule 5
    @Test
    public void should_ignore_common_company_type_abbreviations() {

        assertThat(tenDigitsCode("Guantes Industriales Guadalupe, S. en C.", 29, 11, 1982), startsWith("GIG"));
        assertThat(tenDigitsCode("Construcciones Metálicas Mexicanas, S.A.", 29, 11, 1982), startsWith("CMM"));
        assertThat(tenDigitsCode("Fundición de Precisión Eutectic, S. de R.L.", 29, 11, 1982), startsWith("FPE"));
    }

    // rule 5
    @Test
    public void should_ignore_abbreviation_SA_DE_CV() {

        assertThat(tenDigitsCode("Guantes Industriales, S.A. de C.V.", 29, 11, 1982), startsWith("GIN"));
    }

    // rule 5
    @Test
    public void should_ignore_abbreviation_SCL() {

        assertThat(tenDigitsCode("Guantes Industriales, S.C.L.", 29, 11, 1982), startsWith("GIN"));
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

    private String tenDigitsCode(String legalName, int day, int month, int year) {

        return new JuristicPersonTenDigitsCodeCalculator(new JuristicPerson(legalName, day, month, year)).calculate();
    }
}