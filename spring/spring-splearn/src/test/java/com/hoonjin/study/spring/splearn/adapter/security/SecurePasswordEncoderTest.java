package com.hoonjin.study.spring.splearn.adapter.security;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SecurePasswordEncoderTest {

    @Test
    void securePasswordEncoder() {
        SecurePasswordEncoder securePasswordEncoder = new SecurePasswordEncoder();

        String plainPassword = "123456";
        String passwordHash = securePasswordEncoder.encode("123456");

        assertThat(securePasswordEncoder.matches(plainPassword, passwordHash)).isTrue();
    }

}