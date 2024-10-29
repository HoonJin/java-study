package com.hoonjin.study.java.thread.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import static com.hoonjin.study.java.util.MyLogger.log;

public abstract class ExecutorUtils {

    public static void printState(ExecutorService executorService) {
        if (executorService instanceof ThreadPoolExecutor executor) {
            int poolSize = executor.getPoolSize(); // 스레드풀에서 관리되는 스레드 수
            int activeCount = executor.getActiveCount(); // 작업을 수행중인 스레드 수

            BlockingQueue<Runnable> queue = executor.getQueue();
            int queuedTasks = queue.size(); // 큐에 대기중인작업 수
            long completedTasks = executor.getCompletedTaskCount(); //완료된 작업 수

            log("[pool=" + poolSize + ", active=" + activeCount + ", queuedTasks=" + queuedTasks + ", completedTasks=" + completedTasks + "]");

        } else {
            log(executorService);
        }
    }
}
