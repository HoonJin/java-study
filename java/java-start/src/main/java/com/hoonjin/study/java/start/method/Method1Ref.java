package com.hoonjin.study.java.start.method;

public class Method1Ref {

    public static void main(String[] args) {
        int sum = add(1, 2);
        System.out.println(sum);

        int sum2 = add(5, 4);
        System.out.println(sum2);
    }

    public static int add(int a, int b) {
        System.out.print("(" + a + " + " + b + ") = ");
        return a + b;
    }
}
