package com.hoonjin.study.java.methodref.start;

import java.util.function.BinaryOperator;

public class MethodRefStartV2 {

    public static void main(String[] args) {
        BinaryOperator<Integer> add1 = (a, b) -> add(a, b);
        BinaryOperator<Integer> add2 = (a, b) -> add(a, b);

        System.out.println("add1.apply(1, 2) = " + add1.apply(1, 2));
        System.out.println("add2.apply(1, 2) = " + add2.apply(1, 2));
    }

    private static int add(Integer a, Integer b) {
        return a + b;
    }
}
