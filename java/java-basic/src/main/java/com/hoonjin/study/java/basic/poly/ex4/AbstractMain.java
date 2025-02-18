package com.hoonjin.study.java.basic.poly.ex4;

public class AbstractMain {

    public static void main(String[] args) {
        AbstractAnimal dog = new Dog();

        AbstractAnimal[] animals = {dog, new Cat(), new Cow()};
        for (AbstractAnimal animal : animals) {
            animal.move();
            testSoundAnimal(animal);
        }
    }

    private static void testSoundAnimal(AbstractAnimal animal) {
        System.out.println("동물소리 테스트 시작");
        animal.sound();
        System.out.println("동물소리 테스트 종료");
    }
}
