package com.hoonjin.study.java.optional.model;

import lombok.Getter;

@Getter
public class Address {

    private String street;

    public Address(String street) {
        this.street = street;
    }
}
