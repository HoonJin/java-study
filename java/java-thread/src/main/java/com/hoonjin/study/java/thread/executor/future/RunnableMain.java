package com.hoonjin.study.java.thread.executor.future;

import java.util.Random;

import static com.hoonjin.study.java.util.MyLogger.log;
import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class RunnableMain {

    public static void main(String[] args) throws InterruptedException {

        final var runnable = new Runnable() {
            int value;
            @Override
            public void run() {
                log("Runnable 시작");
                sleep(2000);
                value = new Random().nextInt(10);
                log("value = " + value);
                log("Runnable 완료");
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        thread.join();

        System.out.println("runnable.value = " + runnable.value);
    }
}
