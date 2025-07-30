package com.hoonjin.study.spring.hello;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SimpleHelloService implements HelloService {

    private final HelloRepository helloRepository;

    @Override
    public String sayHello(String name) {
        helloRepository.increaseCount(name);

        return "Hello " + name;
    }

    @Override
    public Integer countOf(String name) {
        return helloRepository.countOf(name);
    }
}
