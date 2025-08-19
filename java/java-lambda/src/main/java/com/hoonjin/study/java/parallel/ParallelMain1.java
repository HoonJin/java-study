package com.hoonjin.study.java.parallel;

import com.hoonjin.study.java.util.MyLogger;

import java.util.stream.IntStream;

public class ParallelMain1 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int sum = IntStream.rangeClosed(1, 8)
            .map(HeavyJob::heavyTask)
            .reduce(0, (a, b) -> a + b);
//            .sum();

        long end = System.currentTimeMillis();
        MyLogger.log("time: " + (end - start) + " ms. sum: " + sum);
    }
}
