package com.hoonjin.study.java.stream.basic;

import com.hoonjin.study.java.lambda.lambda5.mystream.MyStreamV3;

import java.util.List;

public class LazyEvalMain1 {

    public static void main(String[] args) {
        List<Integer> data = List.of(1, 2, 3, 4, 5, 6);
        ex1(data);
        ex2(data);
    }

    private static void ex1(List<Integer> data) {
        System.out.println("== MyStreamV3 시작 ==");
        List<Integer> result = MyStreamV3.of(data)
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
            .toList();
        System.out.println("result = " + result);
        System.out.println("== MyStreamV3 끝 ==");
    }

    private static void ex2(List<Integer> data) {
        System.out.println("== Stream API 시작 ==");
        List<Integer> result = data.stream()
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
            .toList();
        System.out.println("result = " + result);
        System.out.println("== Stream API 끝 ==");
    }
}
