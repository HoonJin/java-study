package com.hoonjin.study.java.lambda.lambda1;

import com.hoonjin.study.java.lambda.MyFunction;

public class LambdaSample1 {

    public static void main(String[] args) {
        // 기본
        MyFunction function1 = (int a, int b) -> {
            return a + b;
        };
        System.out.println("function1.apply(1, 2) = " + function1.apply(1, 2));

        // 단일 표현식인 경우 중괄호와 리턴 생략 가능
        MyFunction function2 = (int a, int b) -> a + b;
        System.out.println("function2.apply(1, 2) = " + function2.apply(1, 2));

        // 단일 표현식인 아닐 경우 중괄호와 리턴 모두 필수
        MyFunction function3 = (int a, int b) -> {
            System.out.println("Adding " + a + " and " + b);
            return a + b;
        };
        System.out.println("function3.apply(1, 2) = " + function3.apply(1, 2));

        // 타입 추론이 가능해서 생략 가능
        MyFunction function4 = (a, b) -> a + b;
        System.out.println("function4.apply(1, 2) = " + function4.apply(1, 2));
    }
}
