package com.hoonjin.study.java.functional;

import java.util.function.Function;

public class CompositionMain2 {

    public static void main(String[] args) {

        Function<String, Integer> parseInt = Integer::parseInt;

        Function<Integer, Integer> square = x -> x * x;

        Function<Integer, String> toString = x -> "결과: " + x;

        Function<String, String> finalFunc = parseInt.andThen(square).andThen(toString);

        String result1 = finalFunc.apply("5");
        System.out.println("result1 = " + result1);
    }
}
