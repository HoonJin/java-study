package com.hoonjin.study.java.start.operator;

public class Operator1 {

    public static void main(String[] args) {
        int a = 5, b = 2;

        int sum = a + b;
        System.out.println("a + b = " + sum);

        int diff = a - b;
        System.out.println("a - b = " + diff);

        int multi = a * b;
        System.out.println("a * b = " + multi);

        int div = a / b;
        System.out.println("a / b = " + div); // int 형은 소수점 표현 불가. 내림 처리
        //int z = a / 0; // java.lang.ArithmeticException: / by zero // 나누기 0을 하면 런타임 에러 발생


        int mod = a % b;
        System.out.println("a % b = " + mod);
    }
}
