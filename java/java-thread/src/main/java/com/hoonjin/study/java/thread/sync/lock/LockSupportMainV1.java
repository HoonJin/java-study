package com.hoonjin.study.java.thread.sync.lock;

import java.util.concurrent.locks.LockSupport;

import static com.hoonjin.study.java.util.MyLogger.log;
import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class LockSupportMainV1 {

    public static void main(String[] args) {
        Runnable task = () -> {
            log("start park");
            LockSupport.park();
            log("end park getState() = " + Thread.currentThread().getState());
            log("isInterrupted() = " + Thread.currentThread().isInterrupted());
        };

        Thread thread = new Thread(task);
        thread.start();

        sleep(100);
        log("thread.getState() = " + thread.getState());

        log("main -> unpark thread");
        LockSupport.unpark(thread); // 1. unpark 로 스레드 깨우기 RUNNABLE, isInterrupted = false
//        thread.interrupt(); // 2. interrupt 로 스레드 마저 실행 RUNNABLE, isInterrupted = true
    }
}
