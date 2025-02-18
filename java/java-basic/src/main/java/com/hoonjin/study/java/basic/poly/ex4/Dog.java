package com.hoonjin.study.java.basic.poly.ex4;

public class Dog extends AbstractAnimal {

    @Override
    public void sound() {
        System.out.println("멍멍");
    }

    @Override
    public void move() {
        System.out.println("Dog.move");
    }
}
