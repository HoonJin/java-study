package com.hoonjin.study.java.ionetwork.reflection;

import com.hoonjin.study.java.ionetwork.reflection.data.BasicData;

import java.lang.reflect.Method;
import java.security.ProtectionDomain;

public class MethodV1 {

    public static void main(String[] args) {
        Class<BasicData> helloClass = BasicData.class;

        System.out.println("----- methods() -----");
        Method[] methods = helloClass.getMethods();
        for (Method method : methods) {
            System.out.println("method = " + method);
        }

        System.out.println("----- getDeclaredMethods() -----");
        Method[] declaredMethods = helloClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("declaredMethod = " + declaredMethod);
        }

    }
}
