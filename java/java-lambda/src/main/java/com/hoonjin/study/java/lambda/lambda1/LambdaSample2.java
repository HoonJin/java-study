package com.hoonjin.study.java.lambda.lambda1;

import com.hoonjin.study.java.lambda.Procedure;

public class LambdaSample2 {

    public static void main(String[] args) {
        // 기본
        Procedure procedure1 = () -> {
            System.out.println("Hello, Lambda!");
        };
        procedure1.run();

        // 단일 표현식인 경우 중괄호 생략 가능
        Procedure procedure2 = () -> System.out.println("Hello, Lambda!");
        procedure2.run();

    }
}
