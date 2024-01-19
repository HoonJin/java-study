package com.hoonjin.study.java.start.method;

public class MethodValue1 {

    public static void main(String[] args) {
        int num1 = 5;
        int num2 = num1;
        num2 = 10;

        System.out.println("1. num1 = " + num1);
        changeNumber(num1);
        System.out.println("호출 후 4. num1 = " + num1);
    }

    public static void changeNumber(int num) {
        System.out.println("2. 변경 전 num = " + num);
        num *= 2;
        System.out.println("3. 변경 후 num = " + num);
    }
}
