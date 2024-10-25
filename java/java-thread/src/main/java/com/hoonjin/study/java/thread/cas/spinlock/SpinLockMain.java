package com.hoonjin.study.java.thread.cas.spinlock;

import static com.hoonjin.study.java.util.MyLogger.log;

public class SpinLockMain {

    public static void main(String[] args) {
//        SpinLockBad lock = new SpinLockBad();
        SpinLock lock = new SpinLock();

        Runnable task = () -> {
            lock.lock();
            try {
                // critical section
                log("비지니스 로직 실행");
            } finally {
                lock.unlock();
            }
        };

        Thread thread = new Thread(task);
        Thread thread0 = new Thread(task);
        thread.start();
        thread0.start();
    }
}
