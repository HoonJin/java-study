package com.hoonjin.study.java.basic.extends1.ex3;

public class CarMain {

    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar();
        electricCar.move();
        electricCar.charge();

        System.out.println();

        GasCar gasCar = new GasCar();
        gasCar.move();
        gasCar.fillUp();

        System.out.println();

        HydrogenCar hydrogenCar = new HydrogenCar();
        hydrogenCar.move();
        hydrogenCar.fillHydrogen();
        hydrogenCar.openDoor();
    }
}
