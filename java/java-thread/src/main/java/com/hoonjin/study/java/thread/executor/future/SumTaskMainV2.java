package com.hoonjin.study.java.thread.executor.future;

import java.util.concurrent.*;

import static com.hoonjin.study.java.util.MyLogger.log;

public class SumTaskMainV2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);

        ExecutorService service = Executors.newFixedThreadPool(2);

        Future<Integer> future1 = service.submit(task1);
        Future<Integer> future2 = service.submit(task2);

        Integer result1 = future1.get();
        Integer result2 = future2.get();

        log("result1 = " + result1);
        log("result2 = " + result2);

        int sum = result1 + result2;
        log("sum = " + sum);

        service.close();
    }

    static class SumTask implements Callable<Integer> {
        int startValue;
        int endValue;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public Integer call() throws InterruptedException {
            log("start callable");
            Thread.sleep(1000);
            int result = 0;
            for (int i = startValue; i <= endValue; i++) {
                result += i;
            }
            log(" end callable result = " + result);
            return result;
        }
    }
}
