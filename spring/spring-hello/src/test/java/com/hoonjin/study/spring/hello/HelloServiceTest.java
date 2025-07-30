package com.hoonjin.study.spring.hello;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.assertj.core.api.Assertions.assertThat;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@UnitTest
@interface FastUnitTest {
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Test
@interface UnitTest {
}

class HelloServiceTest {

    @Test
    void simpleHelloService() {
        SimpleHelloService helloService = new SimpleHelloService(Mockito.mock(HelloRepository.class));

        String result = helloService.sayHello("Test");

        assertThat(result)
            .isEqualTo("Hello Test");
    }

    @Test
    void helloDecorator() {
        HelloDecorator decorator = new HelloDecorator(new SimpleHelloService(Mockito.mock(HelloRepository.class)));
        String result = decorator.sayHello("Test");
        assertThat(result)
            .isEqualTo("*Hello Test*");
    }

}