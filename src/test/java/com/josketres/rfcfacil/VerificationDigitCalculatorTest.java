package com.josketres.rfcfacil;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public class VerificationDigitCalculatorTest {

    @Test
    public void should_calculate_verification_digit() {

        MatcherAssert.assertThat(verificationDigit("GODE561231GR"), Matchers.equalTo("8"));
    }

    private String verificationDigit(String rfc12Digit) {

        return new VerificationDigitCalculator(rfc12Digit).calculate();
    }
}