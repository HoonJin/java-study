package com.hoonjin.study.java.basic.poly.ex3;

public abstract class AbstractAnimal {

    // abstract 를 선언하면 메서드를 구현할 수 없다.
    public abstract void sound();

    public void move() {
        System.out.println("동물이 움직입니다.");
    }
}
