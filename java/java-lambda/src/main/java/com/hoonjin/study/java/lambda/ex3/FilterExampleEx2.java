package com.hoonjin.study.java.lambda.ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterExampleEx2 {

    static List<Integer> filter(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for (Integer i : list) {
            if (predicate.test(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(-3, -2, -1, 1, 2, 3, 5);
        System.out.println("numbers = " + numbers);

        // 음수만
        List<Integer> negative = filter(numbers, i -> i < 0);
        System.out.println("negative = " + negative);

        // 짝수만
        List<Integer> even = filter(numbers, i -> i % 2 == 0);
        System.out.println("even = " + even);
    }
}
