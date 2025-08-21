package com.hoonjin.study.java.parallel;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

import static com.hoonjin.study.java.util.MyLogger.log;

public class ParallelMain6 {

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

        Future<Integer> f1 = es.submit(() -> HeavyJob.heavyTask(1, requestName));
        Future<Integer> f2 = es.submit(() -> HeavyJob.heavyTask(2, requestName));
        Future<Integer> f3 = es.submit(() -> HeavyJob.heavyTask(3, requestName));
        Future<Integer> f4 = es.submit(() -> HeavyJob.heavyTask(4, requestName));

        try {
            Integer i1 = f1.get();
            Integer i2 = f2.get();
            Integer i3 = f3.get();
            Integer i4 = f4.get();
            long end = System.currentTimeMillis();
            int sum = i1 + i2 + i3 + i4;
            log("[" + requestName + "] time: " + (end - start) + " ms. sum: " + sum);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
