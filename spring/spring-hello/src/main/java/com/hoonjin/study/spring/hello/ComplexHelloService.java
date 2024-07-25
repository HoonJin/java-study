package com.hoonjin.study.spring.hello;

public class ComplexHelloService implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name + "!";
    }
}
