package com.hoonjin.study.java.basic.ref;

public class MethodChange1 {

    public static void main(String[] args) {
        int a = 10;
        System.out.println("before a = " + a);
        changePrimitive(a);
        System.out.println("after a = " + a);
    }

    private static void changePrimitive(int x) {
        System.out.println("start x in method = " + x);
        x = 20;
        System.out.println("end x in method = " + x);
    }
}
