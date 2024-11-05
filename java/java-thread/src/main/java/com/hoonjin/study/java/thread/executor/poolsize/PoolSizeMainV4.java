package com.hoonjin.study.java.thread.executor.poolsize;

import com.hoonjin.study.java.thread.executor.RunnableTask;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

import static com.hoonjin.study.java.thread.executor.ExecutorUtils.printState;
import static com.hoonjin.study.java.util.MyLogger.log;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class PoolSizeMainV4 {

//    private static final int TASK_SIZE = 1100; // 1 일반
//    private static final int TASK_SIZE = 1200; // 2 긴급
    private static final int TASK_SIZE = 1300; // 3 거절

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ArrayBlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(1000);
        try (ExecutorService service = new ThreadPoolExecutor(100, 200, 60, MILLISECONDS, blockingQueue)) {
            log("pool 생성");
            printState(service);

            for (int i = 0; i < TASK_SIZE; i++) {
                String taskName = "task" + i;
                try {
                    service.execute(new RunnableTask(taskName));
                    printState(service);
                } catch (RejectedExecutionException e) {
                    log(taskName + " -> " + e);
                }
            }
        }
        long end = System.currentTimeMillis();

        log("걸린시간: " + (end - start) + "ms");
    }
}
