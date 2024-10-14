package com.hoonjin.study.java.thread.control.interrupt;

import static com.hoonjin.study.java.util.MyLogger.log;
import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class ThreadStopMainV2 {

    public static void main(String[] args) {
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.start();

        sleep(4000);
        log("작업 중단 지시 thread.interrupt()");
        thread.interrupt();
        log("thread is interrupted 1 = " + thread.isInterrupted());
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    log("processing");
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                log("thread is interrupted 2 = " + Thread.currentThread().isInterrupted());
                log("interrupt message = " + e.getMessage());
                log("state = " + Thread.currentThread().getState());
            }

            log("cleaning");
            log("end");
        }
    }
}
