package com.hoonjin.study.spring.hello;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringHelloApplication.class)
//@TestPropertySource("classpath:/application.yml")
@TestPropertySource(properties = {
    "data.driver-class-name=org.h2.Driver",
    "data.url=jdbc:h2:mem:",
    "data.username=sa",
    "data.password=",
    "myserver.contextPath=/app",
    "myserver.port=9090",
})
@Transactional
public @interface HelloBootTest {
}
