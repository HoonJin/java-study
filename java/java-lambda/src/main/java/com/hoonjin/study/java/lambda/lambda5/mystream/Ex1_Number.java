package com.hoonjin.study.java.lambda.lambda5.mystream;

import java.util.ArrayList;
import java.util.List;

import static com.hoonjin.study.java.lambda.lambda5.filter.GenericFilter.filter;
import static com.hoonjin.study.java.lambda.lambda5.map.GenericMapper.map;

public class Ex1_Number {

    public static void main(String[] args) {
        // 짝수만 필터링하고, 남은 값의 2배를 반환
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> directResult = direct(numbers);
        System.out.println("directResult = " + directResult);

        List<Integer> lambdaResult = lambda(numbers);
        System.out.println("lambdaResult = " + lambdaResult);
    }

    private static List<Integer> lambda(List<Integer> numbers) {
        return map(filter(numbers, i -> i % 2 == 0), i -> i * 2);
    }

    public static List<Integer> direct(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) { // 짝수만 필터링
                result.add(number * 2);
            }
        }
        return result;
    }
}
