package com.hoonjin.study.java.parallel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static com.hoonjin.study.java.util.MyLogger.log;

public class ParallelMain5 {

    public static void main(String[] args) throws InterruptedException {
        // 병렬 수준을 3으로 제한
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "3");
        ForkJoinPool commonPool = ForkJoinPool.commonPool(); // 디버그용으로 선언. 없어도 된다
        System.out.println("commonPool = " + commonPool);

        ExecutorService executorService = Executors.newFixedThreadPool(100);
        int nThreads = 20;
        for (int i = 0; i < nThreads; i++) {
            String requestName = "request-" + i;
            executorService.submit(() -> logic(requestName));
            Thread.sleep(100);
        }
        executorService.close();
    }

    private static void logic(String requestName) {
        log("[" + requestName + "] START");

        long start = System.currentTimeMillis();

        int sum = IntStream.rangeClosed(1, 4)
            .parallel()
            .map(i -> HeavyJob.heavyTask(i, requestName))
            .sum();

        long end = System.currentTimeMillis();
        log("[" + requestName + "] time: " + (end - start) + " ms. sum: " + sum);
    }
}
