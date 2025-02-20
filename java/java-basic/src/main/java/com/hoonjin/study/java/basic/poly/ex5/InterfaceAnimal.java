package com.hoonjin.study.java.basic.poly.ex5;

public interface InterfaceAnimal {

//    public static final Double MY_PI = 3.14;
    Double MY_PI = 3.14;

    void sound();
    void move();

    default void testSound() {
        System.out.println("동물소리 테스트 시작");
        sound();
        System.out.println("동물소리 테스트 종료");
    }

    static void staticMethod() {
        System.out.println("InterfaceAnimal.test");
    }
}
