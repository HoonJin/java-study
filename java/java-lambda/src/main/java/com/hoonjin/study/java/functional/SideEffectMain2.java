package com.hoonjin.study.java.functional;

import java.util.function.Function;

public class SideEffectMain2 {

    public static void main(String[] args) {
        Function<Integer, Integer> function = x -> {
            int result = x * 2;

            // 엄연히 부수효과
            System.out.println("x = " + x + ", result = " + (x * 2));
            return result;
        };
        function.apply(10);
        function.apply(20);
    }
}
