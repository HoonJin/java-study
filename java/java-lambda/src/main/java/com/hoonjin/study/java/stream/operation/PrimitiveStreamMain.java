package com.hoonjin.study.java.stream.operation;

import java.util.IntSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreamMain {

    public static void main(String[] args) {
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        intStream.forEach(i -> System.out.print(i + " "));
        System.out.println();

        IntStream range1 = IntStream.range(1, 6); // [1,2,3,4,5]
        IntStream range2 = IntStream.rangeClosed(1, 5); // [1,2,3,4,5]

        range1.forEach(i -> System.out.print(i + " "));
        System.out.println();
        range2.forEach(i -> System.out.print(i + " "));
        System.out.println();

        int sum = IntStream.range(1, 6).sum();
        System.out.println("sum = " + sum);

        double avg = IntStream.range(1, 6)
            .average()
            .getAsDouble();
        System.out.println("avg = " + avg);

        // summaryStatistics
        IntSummaryStatistics intSummaryStatistics = IntStream.range(1, 6).summaryStatistics();
        System.out.println("intSummaryStatistics = " + intSummaryStatistics);
        // IntSummaryStatistics{count=5, sum=15, min=1, average=3.000000, max=5}


        // type change
        LongStream longStream = IntStream.range(1, 6).asLongStream();
        DoubleStream doubleStream = IntStream.range(1, 6).asDoubleStream();
        Stream<Integer> boxedStream = IntStream.range(1, 6).boxed();

        LongStream mappedLong = IntStream.range(1, 6)
            .mapToLong(i -> i);

        DoubleStream mappedDouble = IntStream.range(1, 6)
            .mapToDouble(i -> i);

        Stream<String> mappedObj = IntStream.range(1, 6)
            .mapToObj(i -> "Number: " + i);

        // 객체 스트림 -> 기본형 특화스트림 매핑
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        IntStream intStream1 = integerStream.mapToInt(i -> i);

        int result = Stream.of(1, 2, 3, 4, 5)
            .mapToInt(i -> i)
            .sum();
        System.out.println("result = " + result);
    }
}
