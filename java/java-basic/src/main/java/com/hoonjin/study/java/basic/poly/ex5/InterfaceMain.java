package com.hoonjin.study.java.basic.poly.ex5;

public class InterfaceMain {

    public static void main(String[] args) {
        InterfaceAnimal.staticMethod();

        Double myPi = InterfaceAnimal.MY_PI;
        System.out.println("myPi = " + myPi);

        // 인터페이스는 객체 생성 불가
        // InterfaceAnimal interfaceAnimal = new InterfaceAnimal();

        Cat cat = new Cat();
        InterfaceAnimal[] animals = {cat, new Dog(), new Cow()};

        for (InterfaceAnimal animal : animals) {
            animal.testSound();
        }
    }

}
