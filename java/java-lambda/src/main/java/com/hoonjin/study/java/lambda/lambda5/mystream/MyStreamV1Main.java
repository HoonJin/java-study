package com.hoonjin.study.java.lambda.lambda5.mystream;

import java.util.List;

public class MyStreamV1Main {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        returnValue(numbers);
        methodChain(numbers);
    }

    private static void methodChain(List<Integer> numbers) {
        List<Integer> result = new MyStreamV1(numbers)
            .filter(x -> x % 2 == 0)
            .map(x -> x * 2)
            .toList();
        System.out.println("[methodChain]result = " + result);
    }

    private static void returnValue(List<Integer> numbers) {
        MyStreamV1 stream = new MyStreamV1(numbers);
        MyStreamV1 filteredStream = stream.filter(x -> x % 2 == 0);
        System.out.println("[returnValue]filteredStream = " + filteredStream.toList());
        MyStreamV1 mappedStream = filteredStream.map(x -> x * 2);
        List<Integer> result = mappedStream.toList();
        System.out.println("[returnValue]result = " + result);
    }
}
