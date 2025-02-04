package com.hoonjin.study.java.reflection;

import com.hoonjin.study.java.reflection.data.User;

import java.lang.reflect.Field;

public class FieldV2 {

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {

        User userA = new User("id1", "userA", 20);
        System.out.println("userA = " + userA);

        Class<? extends User> aClass = userA.getClass();
        Field nameField = aClass.getDeclaredField("name");

        nameField.setAccessible(true);
        nameField.set(userA, "userB");
        System.out.println("userA = " + userA);
    }
}
