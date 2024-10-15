package com.hoonjin.study.java.thread.volatile1;

import static com.hoonjin.study.java.util.MyLogger.log;
import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class VolatileCountMain {

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask);
        thread.start();
        sleep(1000);

        myTask.flag = false;
        log("count = " + myTask.count + ", flag = " + myTask.flag + " in main()");
    }

    static class MyTask implements Runnable {

        volatile boolean flag = true;
        long count;

        @Override
        public void run() {
            log("task started");
            while (flag) {
                count++;
                if (count % 100_000_000L == 0) {
                    log("count = " + count + ", flag = " + flag + " in run()");
                }
            }
            log("task ended");
        }
    }
}
