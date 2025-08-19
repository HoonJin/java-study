package com.hoonjin.study.java.parallel;

import com.hoonjin.study.java.util.MyLogger;

import java.util.stream.IntStream;

public class ParallelMain2 {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        // fork
        SumTask sumTask1 = new SumTask(1, 4);
        SumTask sumTask2 = new SumTask(5, 8);
        Thread thread1 = new Thread(sumTask1);
        Thread thread2 = new Thread(sumTask2);
        // processing
        thread1.start();
        thread2.start();

        // join
        thread1.join();
        thread2.join();

        int sum = sumTask1.getSum() + sumTask2.getSum();

        long end = System.currentTimeMillis();
        MyLogger.log("time: " + (end - start) + " ms. sum: " + sum);
    }

    static class SumTask implements Runnable {
        private final int start;
        private final int end;
        private int sum;

        public SumTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            MyLogger.log("started.");
            sum = IntStream.rangeClosed(start, end)
                .map(HeavyJob::heavyTask)
                .sum();
            MyLogger.log("finished with sum: " + sum);
        }

        public int getSum() {
            return sum;
        }
    }
}
