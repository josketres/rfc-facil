package com.josketres.rfcfacil;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TenDigitsCodeCalculatorTest {

    @Test
    public void should_calculate_ten_digits_code_for_simple_test_cases() {

        assertThat(
                new TenDigitsCodeCalculator(new Person("Juan", "Barrios", "Fernandez", 13, 12, 1970)).calculate(),
                equalTo("BAFJ701213"));
    }
}
