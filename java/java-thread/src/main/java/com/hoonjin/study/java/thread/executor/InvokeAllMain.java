package com.hoonjin.study.java.thread.executor;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.hoonjin.study.java.util.MyLogger.log;

public class InvokeAllMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        try (ExecutorService service = Executors.newFixedThreadPool(10)) {
            CallableTask task0 = new CallableTask("task0", 1000);
            CallableTask task1 = new CallableTask("task1", 2000);
            CallableTask task2 = new CallableTask("task2", 3000);

            List<Future<Integer>> futures = service.invokeAll(List.of(task0, task1, task2));

            for (Future<Integer> future : futures) {
                Integer value = future.get();
                log( "value = " + value);
            }
        }
    }
}
