package com.hoonjin.study.java.functional;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MutablePerson {

    private String name;
    private int age;

    public MutablePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
