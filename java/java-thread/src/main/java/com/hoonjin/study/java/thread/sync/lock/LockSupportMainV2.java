package com.hoonjin.study.java.thread.sync.lock;

import java.util.concurrent.locks.LockSupport;

import static com.hoonjin.study.java.util.MyLogger.log;
import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class LockSupportMainV2 {

    public static void main(String[] args) {
        Runnable task = () -> {
            log("start park");
            LockSupport.parkNanos(2_000_000_000);
            log("end park getState() = " + Thread.currentThread().getState());
            log("isInterrupted() = " + Thread.currentThread().isInterrupted());
        };

        Thread thread = new Thread(task);
        thread.start();

        sleep(100);
        log("thread.getState() = " + thread.getState());
    }
}
