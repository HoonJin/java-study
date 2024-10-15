package com.hoonjin.study.java.thread.control.yield;

import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class YieldMain {

    static final int THREAD_COUNT = 1000;

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " i = " + i);
//                sleep(1);
                Thread.yield();
            }
        };

        long start = System.currentTimeMillis();
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
        long end = System.currentTimeMillis();

        System.out.println("end - start = " + (end - start));
    }
}
