package com.hoonjin.study.java.start.method;

public class MethodCasting2 {

    public static void main(String[] args) {
        int number = 100;
        printNumber(number); // 자동 형변환이 일어난다.
    }

    public static void printNumber(double number) {
        System.out.println("number = " + number);

    }
}
