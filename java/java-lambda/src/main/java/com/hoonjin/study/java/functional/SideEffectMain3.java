package com.hoonjin.study.java.functional;

import java.util.function.Function;

public class SideEffectMain3 {

    public static void main(String[] args) {
        Function<Integer, Integer> function = x -> x * 2;

        int x = 10;
        Integer result = function.apply(x);
        // 부수효과는 순수함수와 분리해서 실행
        System.out.println("x = " + x + ", result = " + result);
    }
}
