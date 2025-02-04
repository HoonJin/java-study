package com.hoonjin.study.java.reflection.data;

public class BasicData {

    public String publicField;
    private int privateField;

    public BasicData() {
        System.out.println("BasicData = ");
    }

    public BasicData(String publicField) {
        System.out.println("BasicData.publicField = " + publicField);
        this.publicField = publicField;
    }

    public BasicData(int privateField) {
        this.privateField = privateField;
    }

    public void call() {
        System.out.println("BasicData.call()");
    }

    public String hello(String str) {
        System.out.println("BasicData.hello() " + str);
        return str + " hello";
    }

    private void privateMethod() {
        System.out.println("BasicData.privateMethod()");
    }

    void defaultMethod() {
        System.out.println("BasicData.defaultMethod()");
    }

    public void publicMethod() {
        System.out.println("BasicData.publicMethod()");
    }
}
