package com.hoonjin.study.java.optional.model;

import lombok.Getter;

@Getter
public class User {

    private String name;
    private Address address;

    public User(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}
