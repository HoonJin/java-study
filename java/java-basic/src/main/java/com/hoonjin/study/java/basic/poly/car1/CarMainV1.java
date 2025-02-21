package com.hoonjin.study.java.basic.poly.car1;

public class CarMainV1 {

    public static void main(String[] args) {
        Driver driver = new Driver();
        // 차량 선택 및 설정
        Car car = new K3Car();
        driver.setCar(car);

        driver.drive();
    }
}
