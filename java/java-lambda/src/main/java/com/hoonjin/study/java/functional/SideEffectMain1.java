package com.hoonjin.study.java.functional;

import java.util.function.Function;

public class SideEffectMain1 {

    private static int count = 0;

    public static void main(String[] args) {
        System.out.println("before count = " + count);

        Function<Integer, Integer> function = x -> {
            count++;
            return x * 2;
        };
        System.out.println("function.apply(10) = " + function.apply(10));
        System.out.println("after count = " + count);
    }
}
