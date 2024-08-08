package com.hoonjin.study.spring.hello;

import org.springframework.stereotype.Service;

@Service
public class ComplexHelloService implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name + "!";
    }
}
