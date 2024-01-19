package com.hoonjin.study.java.start.method;

public class MethodValue3 {

    public static void main(String[] args) {
        int num1 = 5;
        System.out.println("1. num1 = " + num1); // 5
        num1 = changeNumber(num1);
        System.out.println("호출 후 4. num1 = " + num1); // 5
    }

    public static int changeNumber(int number) {
        System.out.println("2. 변경 전 number = " + number); // 5
        number *= 2;
        System.out.println("3. 변경 후 number = " + number); // 10
        return number;
    }
}
