package com.hoonjin.study.java.basic.extends1.super2;

public class ClassC extends ClassB {

    public ClassC() {
        super(10, 20);
        System.out.println("Constructor of ClassC");
    }

    public ClassC(int a) {
        super(a);
    }

    public ClassC(int a, int b) {
        super(a, b);
    }
}
