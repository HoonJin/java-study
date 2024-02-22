package com.hoonjin.study.java.basic.extends1.overriding;

import com.hoonjin.study.java.basic.extends1.ex2.Car;

public class ElectricCar extends Car {

    @Override
    public void move() {
        System.out.println("move electric car quickly");
    }

    public void charge() {
        System.out.println("charge electric");
    }

}
