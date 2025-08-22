package com.hoonjin.study.java.functional;

import java.util.function.Function;

public class CompositionMain1 {

    public static void main(String[] args) {
        Function<Integer, Integer> square = x -> x * x;
        Function<Integer, Integer> increment = x -> x + 1;

        // compose
        Function<Integer, Integer> newFunction1 = square.compose(increment);
        Integer result = newFunction1.apply(5);
        // square(increment(5)) = square(6) = 36
        System.out.println("result = " + result);

        // andThen
        Function<Integer, Integer> newFunction2 = square.andThen(increment);
        Integer result2 = newFunction2.apply(5);
        // increment(square(5)) = increment(25) = 26
        System.out.println("result2 = " + result2);

    }
}
