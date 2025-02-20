package com.hoonjin.study.java.basic.poly.ex6;

public class Dog extends Animal {

    @Override
    public void sound() {
        System.out.println("멍멍");
    }

    @Override
    public void move() {
        System.out.println("Dog.move");
    }
}
