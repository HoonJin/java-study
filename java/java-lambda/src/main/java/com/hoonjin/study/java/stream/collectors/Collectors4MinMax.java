package com.hoonjin.study.java.stream.collectors;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Collectors4MinMax {

    public static void main(String[] args) {
        // 최소값, 최대값을 구하는 예제
        Optional<Integer> max1 = Stream.of(1, 2, 3, 4, 5)
            .collect(Collectors.maxBy((x, y) -> x.compareTo(y)));
        System.out.println("max1 = " + max1);

        Optional<Integer> max2 = Stream.of(1, 2, 3, 4, 5)
            .max((x, y) -> x.compareTo(y));
        System.out.println("max2 = " + max2);

        Optional<Integer> max3 = Stream.of(1, 2, 3, 4, 5)
            .max(Integer::compareTo);
        System.out.println("max3 = " + max3);

        OptionalInt max4 = IntStream.of(1, 2, 3, 4, 5).max();
        System.out.println("max4 = " + max4);

        int min = Stream.of(1, 2, 3, 4, 5)
            .min(Integer::compareTo)
            .orElseThrow(() -> new RuntimeException("No value present"));
        System.out.println("min = " + min);
    }
}
