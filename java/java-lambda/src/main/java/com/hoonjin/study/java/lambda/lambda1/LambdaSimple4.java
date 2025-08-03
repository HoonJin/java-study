package com.hoonjin.study.java.lambda.lambda1;

public class LambdaSimple4 {

    public static void main(String[] args) {
        MyCall myCall1 = (int value) -> value * 2;
        MyCall myCall2 = (value) -> value * 2;
        MyCall myCall3 = value -> value * 2; // 매개변수가 1개 일 때, 파라미터 괄호 생략 가능

        System.out.println("myCall3.call(10) = " + myCall3.call(10));
    }

    interface MyCall {
        int call(int a);
    }
}
