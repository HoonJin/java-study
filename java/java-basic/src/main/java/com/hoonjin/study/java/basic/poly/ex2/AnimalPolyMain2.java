package com.hoonjin.study.java.basic.poly.ex2;

public class AnimalPolyMain2 {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Animal cat = new Cat();

        Animal[] animals = {dog, cat, new Cow(), new Duck()};

        // 번하지 않는 부분
        for (Animal animal : animals) {
            soundAnimal(animal);
        }
    }

    private static void soundAnimal(Animal animal) {
        System.out.println("동물소리 테스트 시작");
        animal.sound();
        System.out.println("동물소리 테스트 종료");
    }
}
