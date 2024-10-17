package com.hoonjin.study.java.thread.sync.test;

import static com.hoonjin.study.java.util.MyLogger.log;

public class SyncTest2BadMain {

    public static void main(String[] args) throws InterruptedException {
        MyCounter myCounter = new MyCounter();

        Runnable task = () -> myCounter.count();
        Thread thread = new Thread(task);
        Thread thread1 = new Thread(task);

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

    }

    static class MyCounter {

        public void count() {
            int localValue = 0;
            for (int i = 0; i < 1000; i++) {
                localValue++;
            }
            log("localValue = " + localValue);
        }

    }
}
