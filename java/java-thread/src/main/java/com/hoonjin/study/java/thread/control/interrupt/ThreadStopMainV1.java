package com.hoonjin.study.java.thread.control.interrupt;

import static com.hoonjin.study.java.util.MyLogger.log;
import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class ThreadStopMainV1 {

    public static void main(String[] args) {
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.start();

        sleep(4000);
        log("작업 중단 지시 flag = flase");
        task.flag = false;
    }

    static class Task implements Runnable {

        volatile boolean flag = true;

        @Override
        public void run() {
            while (flag) {
                log("processing");
                sleep(3000);
            }
            log("cleaning");
            log("end");
        }
    }
}
