package com.hoonjin.study.java.parallel;

import com.hoonjin.study.java.util.MyLogger;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ParallelMain4 {

    public static void main(String[] args) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ForkJoinPool commonPool = ForkJoinPool.commonPool(); // 디버그용으로 선언. 없어도 된다
        System.out.println("availableProcessors = " + availableProcessors);
        System.out.println("commonPool = " + commonPool);

        long start = System.currentTimeMillis();

        int sum = IntStream.rangeClosed(1, 8)
            .parallel()
            .map(HeavyJob::heavyTask)
            .sum();

        long end = System.currentTimeMillis();
        MyLogger.log("commonPool = " + commonPool);
        MyLogger.log("time: " + (end - start) + " ms. sum: " + sum);
    }
}
