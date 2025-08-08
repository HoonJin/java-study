package com.hoonjin.study.java.methodref;

import lombok.Getter;

public class Person {

    @Getter
    private String name;

    public Person() {
        this("Unknown");
    }

    public Person(String name) {
        this.name = name;
    }

    public static String greeting() {
        return "Hello";
    }

    public static String greetingWithName(String name) {
        return "Hello " + name;
    }

    public String introduce() {
        return "Hello, my name is " + name;
    }

    public String introduceWithNumber(int number) {
        return "Hello, my name is " + name + ". and my number is " + number;
    }
}
