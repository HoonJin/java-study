package com.hoonjin.study.java.parallel;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

import static com.hoonjin.study.java.util.MyLogger.log;

public class ParallelMain7 {

    public static void main(String[] args) throws InterruptedException {
        try (ExecutorService requestPool = Executors.newFixedThreadPool(100);
             ExecutorService logicPool = Executors.newFixedThreadPool(400)
        ) {
            int nThreads = 20;
            for (int i = 0; i < nThreads; i++) {
                String requestName = "request-" + i;
                requestPool.submit(() -> logic(requestName, logicPool));
                Thread.sleep(100);
            }
        }
    }

    private static void logic(String requestName, ExecutorService es) {
        log("[" + requestName + "] START");

        long start = System.currentTimeMillis();

        List<Future<Integer>> futures = IntStream.rangeClosed(1, 4)
            .mapToObj(i -> es.submit(() -> HeavyJob.heavyTask(i, requestName)))
            .toList();
        int sum = futures.stream().mapToInt(f -> {
                try {
                    return f.get();
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            })
            .sum();

        long end = System.currentTimeMillis();
        log("[" + requestName + "] time: " + (end - start) + " ms. sum: " + sum);
    }
}
