package com.hoonjin.study.spring.hello;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hello {

    private String name;
    private Integer count;

    public Hello(String name, Integer count) {
        this.name = name;
        this.count = count;
    }
}
