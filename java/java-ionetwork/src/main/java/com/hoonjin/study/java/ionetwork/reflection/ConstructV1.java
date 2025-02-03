package com.hoonjin.study.java.ionetwork.reflection;

import java.lang.reflect.Constructor;

public class ConstructV1 {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.hoonjin.study.java.ionetwork.reflection.data.BasicData");

        System.out.println("---- constructors() ----");
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("constructor = " + constructor);
        }

        System.out.println("---- declaredConstructors() ----");
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println("declaredConstructor = " + constructor);
        }
    }
}
