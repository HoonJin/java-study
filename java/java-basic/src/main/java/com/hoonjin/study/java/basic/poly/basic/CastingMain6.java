package com.hoonjin.study.java.basic.poly.basic;

public class CastingMain6 {

    public static void main(String[] args) {
        Parent parent1 = new Parent();
        call(parent1);

        Parent parent2 = new Child();
        call(parent2);
    }

    private static void call(Parent parent) {
        if (parent instanceof Child child) {
            System.out.println("Child instance");
            child.childMethod(); // instanceof 의 alias 사용 가능 pattern matching instanceof
        } else {
            System.out.println("Parent instance");
            parent.parentMethod();
        }
    }
}
