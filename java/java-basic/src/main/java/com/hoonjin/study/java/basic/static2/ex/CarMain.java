package com.hoonjin.study.java.basic.static2.ex;

public class CarMain {

    public static void main(String[] args) {
        Car car1 = new Car("K3");
        Car car2 = new Car("Granger");
        Car car3 = new Car("K3");

        Car.showTotalCars();
    }
}
