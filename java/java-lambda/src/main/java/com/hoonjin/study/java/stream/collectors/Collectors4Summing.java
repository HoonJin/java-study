package com.hoonjin.study.java.stream.collectors;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Collectors4Summing {

    public static void main(String[] args) {
        Long count1 = Stream.of(1, 2, 3)
            .collect(counting());// 3
        System.out.println("count1 = " + count1);

        Long count2 = Stream.of(1, 2, 3)
            .count(); // 3
        System.out.println("count2 = " + count2);

        Double average1 = Stream.of(1, 2, 3)
            .collect(averagingInt(i -> i));
        System.out.println("average1 = " + average1);

        double average2 = Stream.of(1, 2, 3).mapToInt(i -> i)
            .average()
            .getAsDouble();
        System.out.println("average2 = " + average2);

        double average3 = IntStream.of(1, 2, 3).average().getAsDouble();
        System.out.println("average3 = " + average3);

        IntSummaryStatistics statistics = Stream.of("Apple", "Banana", "Cherry")
            .collect(summarizingInt(String::length));
        System.out.println("statistics = " + statistics);

    }
}
