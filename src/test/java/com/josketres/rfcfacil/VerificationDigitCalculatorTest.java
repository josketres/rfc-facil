package com.josketres.rfcfacil;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class VerificationDigitCalculatorTest {

    @Test
    public void should_calculate_verification_digit() {

        assertThat(verificationDigit("GODE561231GR"), equalTo("8"));
        assertThat(verificationDigit("AECS211112JP"), equalTo("A"));
        assertThat(verificationDigit("OOGE52071115"), equalTo("1"));
    }

    private String verificationDigit(String rfc12Digit) {

        return new VerificationDigitCalculator(rfc12Digit).calculate();
    }
}
