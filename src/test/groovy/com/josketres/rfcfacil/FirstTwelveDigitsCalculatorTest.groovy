package com.josketres.rfcfacil

import org.junit.Test

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.equalTo

class FirstTwelveDigitsCalculatorTest {

    @Test
    void should_calculate_first_twelve_digits_for_simple_test_cases() {

        assertThat new FirstTwelveDigitsCalculator(
                new Person("Juan", "Barrios", "Fernandez", 13, 12, 1970)).calculate(),
                equalTo("BAFJ701213");
    }
}
