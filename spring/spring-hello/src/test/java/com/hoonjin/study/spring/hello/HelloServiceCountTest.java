package com.hoonjin.study.spring.hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@HelloBootTest
public class HelloServiceCountTest {

    @Autowired
    HelloService helloService;
    @Autowired
    HelloRepository helloRepository;

    @Test
    void sayHelloIncreaseCount() {
        String response = helloService.sayHello("Toby");

        assertThat(response).isEqualTo("*Hello Toby!*");
        assertThat(helloRepository.countOf("Toby")).isEqualTo(1);
    }
}
