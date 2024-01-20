package com.hoonjin.study.java.start.method;

public class Overloading2 {

    public static void main(String[] args) {
        myMethod(1.2, 5);
        myMethod(2, 2.3);
    }

    public static void myMethod(int a, double d) {
        System.out.println("a = " + a + ", d = " + d);
    }

    public static void myMethod(double d, int a) {
        System.out.println("d = " + d + ", a = " + a);
    }
}
