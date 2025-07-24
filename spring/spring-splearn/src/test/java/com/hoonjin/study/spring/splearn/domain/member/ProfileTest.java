package com.hoonjin.study.spring.splearn.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProfileTest {

    @Test
    void profile() {
        new Profile("tobyilee");
        new Profile("toby100");
        new Profile("");
    }

    @Test
    void profileFail() {
        Assertions.assertThatThrownBy(() -> new Profile("asdfasdfasdfasdfasdfasdf"))
            .isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> new Profile("!24r"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void url() {
        Profile profile = new Profile("tobyilee");

        assertThat(profile.url()).isEqualTo("@tobyilee");
    }

}
