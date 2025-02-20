package com.hoonjin.study.java.basic.poly.ex6;

public class SoundFlyMain {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Bird bird = new Bird();
        Chicken chicken = new Chicken();

        testSoundAnimal(dog);
        testSoundAnimal(bird);
        testSoundAnimal(chicken);

//        flyAnimal(dog); // Fly 를 구현하지 않았으므로 불가능
        flyAnimal(bird);
        flyAnimal(chicken);
    }

    private static void testSoundAnimal(Animal animal) {
        System.out.println("동물소리 테스트 시작");
        animal.sound();
        System.out.println("동물소리 테스트 종료");
    }

    private static void flyAnimal(Fly fly) {
        System.out.println("동물 날기 테스트 시작");
        fly.fly();
        System.out.println("동물 날기 테스트 종료");
    }
}
