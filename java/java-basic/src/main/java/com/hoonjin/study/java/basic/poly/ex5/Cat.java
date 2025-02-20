package com.hoonjin.study.java.basic.poly.ex5;

public class Cat implements InterfaceAnimal {

    @Override
    public void sound() {
        System.out.println("야옹");
    }

    @Override
    public void move() {
        System.out.println("Cat.move");
    }
}
