package com.hoonjin.study.java.basic.ref;

public class VarChange1 {

    public static void main(String[] args) {
        int a = 10;
        int b = a;
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        a = 20;
        System.out.println("a = 20 변경");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        // a 값이 변경된다 하더라도 b 값까지 변경되진 않는다

        b = 30;
        System.out.println("b = 30 변경");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
