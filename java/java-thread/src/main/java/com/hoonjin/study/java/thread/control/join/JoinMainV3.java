package com.hoonjin.study.java.thread.control.join;

import static com.hoonjin.study.java.util.MyLogger.log;

public class JoinMainV3 {

    public static void main(String[] args) throws InterruptedException {
        log("Start");
        SumTask task0 = new SumTask(1, 50);
        SumTask task1 = new SumTask(51, 100);

        Thread thread0 = new Thread(task0, "thread-0");
        Thread thread1 = new Thread(task1, "thread-1");

        thread0.start();
        thread1.start();

        log("join() - main thread will be waiting when threads are completed");
        thread0.join();
        thread1.join();

        int result0 = task0.result;
        log("task0.result = " + result0);
        int result1 = task1.result;
        log("task1.result = " + result1);

        int sum = result0 + result1;
        log("sum = " + sum);

        log("End");
    }
}
