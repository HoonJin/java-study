package com.hoonjin.study.java.lambda.lambda5.filter;

import java.util.List;

public class FilterMainV4 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 1. 짝수만 필터링
        List<Integer> evenNumbers = IntegerFilter.filter(numbers, n -> n % 2 == 0);
        System.out.println("evenNumbers = " + evenNumbers);

        // 2. 홀수만 필터링
        List<Integer> oddNumbers = IntegerFilter.filter(numbers, n -> n % 2 == 1);
        System.out.println("oddNumbers = " + oddNumbers);
    }
}
