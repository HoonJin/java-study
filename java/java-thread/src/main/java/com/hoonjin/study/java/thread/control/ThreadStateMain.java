package com.hoonjin.study.java.thread.control;

import static com.hoonjin.study.java.util.MyLogger.log;
import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class ThreadStateMain {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            log("myThread.getState()2 = " + Thread.currentThread().getState());
            log("sleep start");
            sleep(3000);
            log("sleep end");
            log("myThread.getState()4 = " + Thread.currentThread().getState());
        };
        Thread myThread = new Thread(runnable, "myThread");

        log("myThread.getState()1 = " + myThread.getState());
        log("myThread.start()");
        myThread.start();

        sleep(1000);
        log("myThread.getState()3 = " + myThread.getState());

        sleep(4000);
        log("myThread.getState()5 = " + myThread.getState());

        log("end");
    }
}
