package com.hoonjin.study.java.functional;

import java.util.function.Function;

public class FirstClassCitizenMain {
    public static void main(String[] args) {
        Function<Integer, Integer> func = i -> i * 2;

        applyFunction(10, func);
        System.out.println("applyFunction(10, func) = " + applyFunction(10, func));

        getFunc().apply(20);
        System.out.println("getFunc().apply(20) = " + getFunc().apply(20));
    }

    private static Integer applyFunction(int i, Function<Integer, Integer> func) {
        return func.apply(i);
    }

    private static Function<Integer, Integer> getFunc() {
        return x -> x * 2;
    }
}
