package com.hoonjin.study.java.basic.static2.ex;

public class Car {
    private static int count;

    private String name;

    public Car(String name) {
        this.name = name;
        count++;
    }

    public static void showTotalCars() {
        System.out.println("count = " + count);
    }
}
