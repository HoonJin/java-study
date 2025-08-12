package com.hoonjin.study.java.stream.operation;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class intermediateOperationsMain {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 2, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10);

        System.out.println("filter 짝수만 출력");
        numbers.stream()
            .filter(n -> n % 2 == 0)
            .forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("map 제곱");
        numbers.stream()
            .map(n -> n * n)
            .forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("distinct 중복제거");
        numbers.stream()
            .distinct()
            .forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("sorted 기본 정렬");
        Stream.of(3, 1, 2, 4, 7, 5, 6)
            .sorted()
            .forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("sorted 역순 정렬");
        Stream.of(3, 1, 2, 4, 7, 5, 6)
            .sorted(Comparator.reverseOrder())
            .forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("peek 동작 확인");
        numbers.stream()
            .peek(n -> System.out.print("before: " + n + ", "))
            .map(n -> n * n)
            .peek(n -> System.out.print("after: " + n + ", "))
            .limit(5)
            .forEach(n -> System.out.println("최종값: " + n + " "));
        System.out.println();

        System.out.println("limit 첫 5개 요소");
        numbers.stream()
            .limit(5)
            .forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("skip 첫 5개 요소 건너뛰기");
        numbers.stream()
            .skip(5)
            .forEach(n -> System.out.print(n + " "));
        System.out.println();

        List<Integer> numbers2 = List.of(1, 2, 3, 4, 5, 1, 2, 3);
        System.out.println("takeWhile 조건 만족하는 요소들까지만");
        numbers2.stream()
            .takeWhile(n -> n < 5)
            .forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("dropWhile 조건 만족하는 요소들까지 건너뛰기");
        numbers2.stream()
            .dropWhile(n -> n < 5)
            .forEach(n -> System.out.print(n + " "));
    }
}
