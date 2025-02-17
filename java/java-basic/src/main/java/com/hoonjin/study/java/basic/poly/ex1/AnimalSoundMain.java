package com.hoonjin.study.java.basic.poly.ex1;

public class AnimalSoundMain {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Cow cow = new Cow();

        soundDog(dog);
        soundCat(cat);
        soundCow(cow);
    }

    private static void soundCow(Cow cow) {
        System.out.println("동물소리 테스트 시작");
        cow.sound();
        System.out.println("동물소리 테스트 종료");
    }

    private static void soundCat(Cat cat) {
        System.out.println("동물소리 테스트 시작");
        cat.sound();
        System.out.println("동물소리 테스트 종료");
    }

    private static void soundDog(Dog dog) {
        System.out.println("동물소리 테스트 시작");
        dog.sound();
        System.out.println("동물소리 테스트 종료");
    }
}
