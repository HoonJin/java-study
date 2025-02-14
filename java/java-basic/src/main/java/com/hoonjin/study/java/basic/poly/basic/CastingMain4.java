package com.hoonjin.study.java.basic.poly.basic;

public class CastingMain4 {

    // 다운 캐스팅이 자동으로 되지 않는 이유
    public static void main(String[] args) {
        Parent parent1 = new Child();
        Child child1 = (Child) parent1;
        child1.childMethod();

        Parent parent2 = new Parent();
        Child child2 = (Child) parent2; // ClassCastException
        // ClassCastException: class Parent cannot be cast to class Child (Parent and Child are in unnamed module of loader 'app')
        child2.childMethod();

    }
}
