package com.hoonjin.study.java.stream.operation;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalOperationMain {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 2, 2, 3, 4, 5, 5, 6, 6, 7, 8, 9, 10);

        System.out.println("1. Collectors.toList()");
        List<Integer> evenNumbers1 = numbers.stream()
            .filter(x -> x % 2 == 0)
            .collect(Collectors.toList());
        System.out.println("evenNumbers1 = " + evenNumbers1);

        System.out.println("2. .toList()");
        List<Integer> evenNumbers2 = numbers.stream()
            .filter(x -> x % 2 == 0)
            .toList();
        System.out.println("evenNumbers2 = " + evenNumbers2);

        System.out.println("3. toArray()");
        Integer[] evenNumbersArray = numbers.stream()
            .filter(x -> x % 2 == 0)
            .toArray(Integer[]::new);
        System.out.println("evenNumbersArray = " + Arrays.toString(evenNumbersArray));

        System.out.println("4. forEach");
        numbers.stream().forEach(System.out::print);
        System.out.println();

        System.out.println("5. count");
        long count = numbers.stream()
            .filter(x -> x > 5)
            .count();
        System.out.println("count = " + count);

        System.out.println("6. reduce (초기값 없음)");
        Optional<Integer> sum1 = numbers.stream()
            .reduce((x, y) -> x + y);
        System.out.println("sum1 = " + sum1);

        System.out.println("6-2. reduce (초기값 있음)");
        Integer sum2 = numbers.stream()
            .reduce(0, (x, y) -> x + y);
        System.out.println("sum2 = " + sum2);

        System.out.println("7. min");
        Optional<Integer> min = numbers.stream()
            .min(Integer::compareTo);
        System.out.println("min = " + min);

        System.out.println("8. max");
        Optional<Integer> max = numbers.stream()
            .max(Integer::compareTo);
        System.out.println("max = " + max);

        System.out.println("9. findFirst");
        Optional<Integer> first = numbers.stream()
            .filter(x -> x > 5)
            .findFirst();
        System.out.println("first = " + first);

        System.out.println("10. findAny");
        Optional<Integer> any = numbers.stream()
            .filter(x -> x > 5)
            .findAny();
        System.out.println("any = " + any);

        System.out.println("11. anyMatch");
        boolean hasEven = numbers.stream()
            .anyMatch(x -> x % 2 == 0);
        System.out.println("hasEven = " + hasEven);

        System.out.println("12. allMatch");
        boolean allPositive = numbers.stream()
            .allMatch(x -> x > 0);
        System.out.println("allPositive = " + allPositive);

        System.out.println("13. noneMatch");
        boolean noneNegative = numbers.stream()
            .noneMatch(x -> x < 0);
        System.out.println("noneNegative = " + noneNegative);
    }
}
