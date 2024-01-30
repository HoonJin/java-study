package com.hoonjin.study.java.basic.access.a;

public class AccessData {

    public int publicField;
    int defaultField;
    private int privateField;

    public void publicMethod() {
        System.out.println("publicField = " + publicField);
    }

    void defaultMethod() {
        System.out.println("defaultField = " + defaultField);
    }

    private void privateMethod() {
        System.out.println("privateField = " + privateField);
    }

    public void innerAccess() {
        System.out.println("내부 호출");
        publicField = 100;
        defaultField = 200;
        privateField = 300;
        publicMethod();
        defaultMethod();
        privateMethod();
    }
}
