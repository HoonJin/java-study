package com.hoonjin.study.java.thread.start.test;

import static com.hoonjin.study.java.util.MyLogger.log;

public class StartTest4Main {

    public static void main(String[] args) {

        Thread threadA = new Thread(() -> logging("A", 1000), "Thread-A");
        Thread threadB = new Thread(() -> logging("B", 500), "Thread-B");
        threadA.start();
        threadB.start();
    }

    private static void logging(String str, int sleepMs) {
        while (true) {
            try {
                log(str);
                Thread.sleep(sleepMs);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
