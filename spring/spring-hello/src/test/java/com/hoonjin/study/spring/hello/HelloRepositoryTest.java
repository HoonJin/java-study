package com.hoonjin.study.spring.hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@HelloBootTest
class HelloRepositoryTest {

    @Autowired
    HelloRepository helloRepository;

    @Test
    void findFailed() {
        assertThat(helloRepository.findHello("test")).isNull();
    }

    @Test
    void increaseCount() {
        assertThat(helloRepository.countOf("Toby")).isEqualTo(0);

        helloRepository.increaseCount("Toby");
        assertThat(helloRepository.countOf("Toby")).isEqualTo(1);

        helloRepository.increaseCount("Toby");
        assertThat(helloRepository.countOf("Toby")).isEqualTo(2);
    }

}