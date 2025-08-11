package com.hoonjin.study.java.stream.basic;

import com.hoonjin.study.java.lambda.lambda5.mystream.MyStreamV3;

import java.util.List;

public class LazyEvalMain3 {

    public static void main(String[] args) {
        List<Integer> data = List.of(1, 2, 3, 4, 5, 6);
        ex1(data);
        ex2(data);
    }

    private static void ex1(List<Integer> data) {
        System.out.println("== MyStreamV3 시작 ==");
        Integer first = MyStreamV3.of(data)
            .filter(value -> {
                boolean isEven = value % 2 == 0;
                System.out.println("filter(): " + value + ", isEven: " + isEven);
                return isEven;
            })
            .map(value -> {
                int mapped = value * 10;
                System.out.println("map(): " + value + " * 10 = " + mapped);
                return mapped;
            })
            .getFirst();
        System.out.println("first = " + first);
        System.out.println("== MyStreamV3 끝 ==");
    }

    private static void ex2(List<Integer> data) {
        System.out.println("== Stream API 시작 ==");
        Integer first = data.stream()
            .filter(value -> {
                boolean isEven = value % 2 == 0;
                System.out.println("filter(): " + value + ", isEven: " + isEven);
                return isEven;
            })
            .map(value -> {
                int mapped = value * 10;
                System.out.println("map(): " + value + " * 10 = " + mapped);
                return mapped;
            })
            .findFirst().get();
        System.out.println("first = " + first);
        System.out.println("== Stream API 끝 ==");
    }
}
