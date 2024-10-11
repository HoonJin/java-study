package com.hoonjin.study.java.thread.start.test;

import static com.hoonjin.study.java.util.MyLogger.log;

public class StartTest2Main {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    log("value: " + i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
    }
}
