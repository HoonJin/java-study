package com.hoonjin.study.java.ionetwork.reflection;

import com.hoonjin.study.java.ionetwork.reflection.data.BasicData;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FieldV1 {

    public static void main(String[] args) {
        Class<BasicData> helloClass = BasicData.class;

        System.out.println("----- getFields() -----");
        Field[] fields = helloClass.getFields();
        for (Field field : fields) {
            System.out.println("field = " + field);
        }

        System.out.println("----- getDeclaredFields() -----");
        Field[] declaredFields = helloClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("declaredField = " + declaredField);
        }

    }
}
