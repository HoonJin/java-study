package com.hoonjin.study.spring.rest1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRest1Application {

    public static void main(String[] args) {
//        ApplicationContext ac = SpringApplication.run(Rest1Application.class, args);
//
//        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
//        for (String bean : beanDefinitionNames) {
//            System.out.println("bean = " + bean);
//        }
        SpringApplication.run(SpringRest1Application.class, args);
    }
}
