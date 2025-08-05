package com.hoonjin.study.java.lambda.ex3;

import java.util.List;
import java.util.function.BinaryOperator;

public class ReduceExampleEx2 {

    static int reduce(List<Integer> list, int initial, BinaryOperator<Integer> reducer) {
        int result = initial;
        for (Integer i : list) {
            result = reducer.apply(result, i);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2,3,4);
        System.out.println("numbers = " + numbers);

        // 음수만
        int sum = reduce(numbers, 0, (a, b) -> a + b);
        System.out.println("sum = " + sum);

        // 짝수만
        int product = reduce(numbers, 1, (a, b) -> a * b);
        System.out.println("product = " + product);
    }

}
