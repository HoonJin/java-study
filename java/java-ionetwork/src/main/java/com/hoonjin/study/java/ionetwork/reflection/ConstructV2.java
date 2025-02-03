package com.hoonjin.study.java.ionetwork.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ConstructV2 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("com.hoonjin.study.java.ionetwork.reflection.data.BasicData");

        Constructor<?> constructor = aClass.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        Object hello = constructor.newInstance("hello");
        System.out.println("hello = " + hello);

        Method method = aClass.getDeclaredMethod("call");
        method.invoke(hello);
    }
}
