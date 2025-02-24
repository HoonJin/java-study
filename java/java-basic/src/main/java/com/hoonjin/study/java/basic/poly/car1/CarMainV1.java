package com.hoonjin.study.java.basic.poly.car1;

public class CarMainV1 {

    public static void main(String[] args) {
        Driver driver = new Driver();
        // 차량 선택 및 설정
        Car car = new K3Car();
        driver.setCar(car);

        driver.drive();

        // NewCar 사용을 추가하더라도 Driver class 는 전혀 변경하지 않는다
        Car newCar = new NewCar();
        driver.setCar(newCar);
        driver.drive();
    }
}
