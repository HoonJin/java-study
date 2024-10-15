package com.hoonjin.study.java.thread.volatile1;

import static com.hoonjin.study.java.util.MyLogger.log;
import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class VolatileFlagMain {

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask);
        log("runFlag = " + myTask.runFlag);
        thread.start();
        sleep(1000);
        log("runFlag = " + myTask.runFlag);

        myTask.runFlag = false;

        log("runFlag = " + myTask.runFlag);
        log("main ended");

    }

    static class MyTask implements Runnable {

        volatile boolean runFlag = true;

        @Override
        public void run() {
            log("task started");
            while (runFlag) {

            }
            log("task ended");
        }
    }
}
