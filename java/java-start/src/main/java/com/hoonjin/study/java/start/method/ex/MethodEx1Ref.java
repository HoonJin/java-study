package com.hoonjin.study.java.start.method.ex;

public class MethodEx1Ref {

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        double average = average(a, b, c);
        System.out.println("average = " + average);

        double average1 = average(15, 25, 35);
        System.out.println("average1 = " + average1);

    }

    public static int sum(int a, int b, int c) {
        return a + b + c;
    }

    public static double average(int a, int b, int c) {
        int sum = sum(a, b, c);
        return sum / 3.0;
    }
}
