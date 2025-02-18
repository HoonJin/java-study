package com.hoonjin.study.java.basic.poly.ex3;

public class AbstractMain {

    public static void main(String[] args) {
        // abstract class 는 생성할 수 없음
//        AbstractAnimal abstractAnimal = new AbstractAnimal();
        AbstractAnimal dog = new Dog();

        AbstractAnimal[] animals = {dog, new Cat(), new Cow()};
        for (AbstractAnimal animal : animals) {
            soundAnimal(animal);
        }
    }

    private static void soundAnimal(AbstractAnimal animal) {
        System.out.println("동물소리 테스트 시작");
        animal.sound();
        System.out.println("동물소리 테스트 종료");
    }
}
