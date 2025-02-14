package com.hoonjin.study.java.basic.poly.basic;

public class CastingMain5 {

    public static void main(String[] args) {
        Parent parent1 = new Parent();
        call(parent1);

        Parent parent2 = new Child();
        call(parent2);

        System.out.println(new Parent() instanceof Parent); // true
        System.out.println(new Child() instanceof Parent); // true

        System.out.println(new Parent() instanceof Child); // false
        System.out.println(new Child() instanceof Child); // true
    }

    private static void call(Parent parent) {
         if (parent instanceof Child) {
            System.out.println("Child instance");
             ((Child) parent).childMethod();
        } else {
            System.out.println("Parent instance");
            parent.parentMethod();
        }
    }
}
