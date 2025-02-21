package com.hoonjin.study.java.basic.poly.car1;

public class Driver {

    private Car car;

    public void setCar(Car car) {
        System.out.println("car = " + car.getClass().getSimpleName());
        this.car = car;
    }

    public void drive() {
        System.out.println("Driver.drive");
        car.startEngine();
        car.pressAccelerator();
        car.offEngine();
    }
}
