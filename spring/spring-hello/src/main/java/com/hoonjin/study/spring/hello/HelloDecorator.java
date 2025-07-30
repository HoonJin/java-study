package com.hoonjin.study.spring.hello;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@RequiredArgsConstructor
public class HelloDecorator implements HelloService {

    private final HelloService helloService;

    @Override
    public String sayHello(String name) {
        return "*" + helloService.sayHello(name) + "*";
    }

    @Override
    public Integer countOf(String name) {
        return helloService.countOf(name);
    }
}
