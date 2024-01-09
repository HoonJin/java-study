package com.hoonjin.study.java.start.operator;

public class OperatorAdd1 {

    public static void main(String[] args) {
        int a = 0;

        a = a + 1;
        System.out.println("a = " + a); // 1

        // 증감연산자
        ++a;
        System.out.println("a = " + a); // 2
        System.out.println("++a = " + ++a); // 3 // a 변수 선연산 후 처리
        System.out.println("a = " + a); // 3

        a++;
        System.out.println("a = " + a); // 4
        System.out.println("a++ = " + a++); // a 변수 처리 후 연산
        System.out.println("a = " + a); // 5

        a--;
        System.out.println("a = " + a); // 4
    }
}
