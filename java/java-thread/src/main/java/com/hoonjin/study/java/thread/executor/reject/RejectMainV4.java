package com.hoonjin.study.java.thread.executor.reject;

import com.hoonjin.study.java.thread.executor.RunnableTask;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

import static com.hoonjin.study.java.util.MyLogger.log;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class RejectMainV4 {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 0, MILLISECONDS, new SynchronousQueue<>(), new MyRejectedExecutionHandler());
        executor.submit(new RunnableTask("task1"));

        executor.submit(new RunnableTask("task2"));
        executor.submit(new RunnableTask("task3"));
        executor.submit(new RunnableTask("task4"));

        executor.close();
    }

    static class MyRejectedExecutionHandler implements RejectedExecutionHandler {

        static AtomicInteger cnt = new AtomicInteger(0);
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            int i = cnt.incrementAndGet();
            log("거절된 작업의 수: " + i);
        }
    }

}
