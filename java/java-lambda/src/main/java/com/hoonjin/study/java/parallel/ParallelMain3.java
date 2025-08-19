package com.hoonjin.study.java.parallel;

import com.hoonjin.study.java.util.MyLogger;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ParallelMain3 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        try (ExecutorService es = Executors.newFixedThreadPool(2)) {
            SumTask sumTask1 = new SumTask(1, 4);
            SumTask sumTask2 = new SumTask(5, 8);

            Future<Integer> future1 = es.submit(sumTask1);
            Future<Integer> future2 = es.submit(sumTask2);

            Integer result1 = future1.get();
            Integer result2 = future2.get();
            int sum = result1 + result2;

            long end = System.currentTimeMillis();
            MyLogger.log("time: " + (end - start) + " ms. sum: " + sum);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static class SumTask implements Callable<Integer> {
        private final int start;
        private final int end;

        public SumTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public Integer call() {
            MyLogger.log("started.");
            int sum = IntStream.rangeClosed(start, end)
                .map(HeavyJob::heavyTask)
                .sum();
            MyLogger.log("finished with sum: " + sum);
            return sum;
        }
    }
}
