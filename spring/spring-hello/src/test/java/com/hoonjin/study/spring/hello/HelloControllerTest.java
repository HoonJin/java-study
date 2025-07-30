package com.hoonjin.study.spring.hello;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HelloControllerTest {

    @Test
    void helloController() {
        HelloController helloController = new HelloController(new SimpleHelloService(Mockito.mock(HelloRepository.class)));

        String result = helloController.hello("Test");
        assertThat(result)
            .isEqualTo("Hello Test");
    }

    @Test
    void failsHelloController() {
        HelloController helloController = new HelloController(Mockito.mock(HelloService.class));

        assertThatThrownBy(() ->
            helloController.hello(null)
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() ->
            helloController.hello("")
        ).isInstanceOf(IllegalArgumentException.class);
    }

}