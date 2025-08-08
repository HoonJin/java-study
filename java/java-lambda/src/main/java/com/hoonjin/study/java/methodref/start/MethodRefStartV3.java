package com.hoonjin.study.java.methodref.start;

import java.util.function.BinaryOperator;

public class MethodRefStartV3 {

    public static void main(String[] args) {
        BinaryOperator<Integer> add1 = MethodRefStartV3::add;
        BinaryOperator<Integer> add2 = MethodRefStartV3::add;

        System.out.println("add1.apply(1, 2) = " + add1.apply(1, 2));
        System.out.println("add2.apply(1, 2) = " + add2.apply(1, 2));
    }

    private static int add(Integer a, Integer b) {
        return a + b;
    }
}
