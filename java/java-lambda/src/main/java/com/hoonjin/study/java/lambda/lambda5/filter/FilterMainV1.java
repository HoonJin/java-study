package com.hoonjin.study.java.lambda.lambda5.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterMainV1 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 1. 짝수만 필터링
        List<Integer> evenNumbers = filterEvenNumbers(numbers);
        System.out.println("evenNumbers = " + evenNumbers);

        // 2. 홀수만 필터링
        List<Integer> oddNumbers = filterOddNumbers(numbers);
        System.out.println("oddNumbers = " + oddNumbers);
    }

    private static List<Integer> filterEvenNumbers(List<Integer> numbers) {
        ArrayList<Integer> filtered = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                filtered.add(number);
            }
        }
        return filtered;
    }

    private static List<Integer> filterOddNumbers(List<Integer> numbers) {
        ArrayList<Integer> filtered = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 1) {
                filtered.add(number);
            }
        }
        return filtered;
    }

}
