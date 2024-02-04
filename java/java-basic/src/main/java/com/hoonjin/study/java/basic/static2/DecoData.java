package com.hoonjin.study.java.basic.static2;

public class DecoData {

    private int instanceValue;
    private static int staticValue;

    public static void staticCall() {
        // instanceValue++ // compile error
        // instanceMethod(); // compile error

        staticValue++;
        staticMethod();
    }

    public static void staticCall(DecoData data) {
        data.instanceValue++;
        data.instanceMethod();
    }

    public void instanceCall() {
        instanceValue++; // accessible instance variable
        instanceMethod();

        staticValue++; // accessible static variable
        staticMethod();
    }

    private void instanceMethod() {
        System.out.println("instanceValue = " + instanceValue);
    }

    static void staticMethod() {
        System.out.println("staticValue = " + staticValue);
    }
}

