package com.hoonjin.study.java.thread.start.test;

import static com.hoonjin.study.java.util.MyLogger.log;

public class StartTest1Main {

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        log("value: " + i);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        thread.start();
    }
}
