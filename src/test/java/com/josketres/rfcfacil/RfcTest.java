package com.josketres.rfcfacil;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RfcTest {

    @Test
    public void should_build_rfc() {

        Rfc rfc = new Rfc.Builder()
                .name("Josué")
                .firstLastName("Zarzosa")
                .secondLastName("de la Torre")
                .birthday(5, 8, 1987)
                .build();

        assertThat(rfc.tenDigitsCode, equalTo("ZATJ870805"));
        assertThat(rfc.homoclave, equalTo("CK"));
        assertThat(rfc.verificationDigit, equalTo("6"));
        assertThat(rfc.toString(), equalTo("ZATJ870805CK6"));
    }
}