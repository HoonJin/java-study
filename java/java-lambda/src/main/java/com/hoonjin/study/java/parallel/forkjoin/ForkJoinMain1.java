package com.hoonjin.study.java.parallel.forkjoin;

import com.hoonjin.study.java.util.MyLogger;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ForkJoinMain1 {

    public static void main(String[] args) {
        List<Integer> data = IntStream.rangeClosed(1, 8).boxed().toList();

        long start = System.currentTimeMillis();

        try (ForkJoinPool forkJoinPool = new ForkJoinPool(10)) {
            SumTask task = new SumTask(data);

            Integer sum = forkJoinPool.invoke(task);

            long end = System.currentTimeMillis();
            MyLogger.log("time: " + (end - start) + " ms. sum: " + sum);

            MyLogger.log("forkJoinPool = " + forkJoinPool);
        }
    }
}
