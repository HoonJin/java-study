package com.hoonjin.study.java.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.hoonjin.study.java.thread.executor.ExecutorUtils.printState;
import static com.hoonjin.study.java.util.MyLogger.log;

public class PoolSizeMainV2 {

    public static void main(String[] args) {
        try (ExecutorService service = Executors.newFixedThreadPool(2)) {
            log("pool 생성");
            printState(service);

            for (int i = 0; i < 6; i++) {
                String taskName = "task" + i;
                service.submit(new RunnableTask(taskName));
                printState(service, taskName);
            }
        }
    }
}
