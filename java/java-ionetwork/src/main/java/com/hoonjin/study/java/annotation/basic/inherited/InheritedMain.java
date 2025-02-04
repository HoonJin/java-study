package com.hoonjin.study.java.annotation.basic.inherited;

import java.lang.annotation.Annotation;

public class InheritedMain {

    public static void main(String[] args) {
        print(Parent.class);
        print(Child.class);
        print(TestInterface.class);
        print(TestInterfaceImpl.class); // 인터페이스 구현은 어노테이션이 적용되지 않는다.
    }

    private static void print(Class<?> clazz) {
        System.out.println("clazz = " + clazz);
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("  - " + annotation.annotationType().getSimpleName());
        }
    }
}
