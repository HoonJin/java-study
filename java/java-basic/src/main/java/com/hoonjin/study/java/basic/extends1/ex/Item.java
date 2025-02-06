package com.hoonjin.study.java.basic.extends1.ex;

import lombok.Getter;

@Getter
public class Item {

    private String name;
    private Integer price;

    public Item(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public void print() {
        System.out.println("name = " + name + ", price = " + price);
    }
}
