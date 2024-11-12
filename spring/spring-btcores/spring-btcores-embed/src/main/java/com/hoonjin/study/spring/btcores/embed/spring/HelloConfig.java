package com.hoonjin.study.spring.btcores.embed.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@ComponentScan
public class HelloConfig {

    @Bean
    public HelloController helloController() {
        return new HelloController();
    }
}
