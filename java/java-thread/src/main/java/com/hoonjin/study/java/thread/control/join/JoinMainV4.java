package com.hoonjin.study.java.thread.control.join;

import static com.hoonjin.study.java.util.MyLogger.log;
import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class JoinMainV4 {

    public static void main(String[] args) throws InterruptedException {
        log("Start");
        SumTask task0 = new SumTask(1, 50);
        Thread thread0 = new Thread(task0, "thread-0");

        thread0.start();

        log("join(500) - main thread will be waiting in 500 ms");
        thread0.join(500);

        int result0 = task0.result;
        log("task0.result = " + result0);

        log("End");
    }
}
