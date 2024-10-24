package com.hoonjin.study.java.thread.cas.increment;

import java.util.ArrayList;
import java.util.List;

import static com.hoonjin.study.java.util.MyLogger.log;
import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class IncrementThreadMain {

    public static final int THREAD_COUNT = 1000;

    public static void main(String[] args) throws InterruptedException {
        test(new BasicIncrementInteger());
        test(new VolatileIncrementInteger());
        test(new SyncIncrementInteger());
        test(new MyAtomicIncrementInteger());
    }

    private static void test(IncrementInteger incrementInteger) throws InterruptedException {
        Runnable task = () -> {
            sleep(10);
            incrementInteger.increment();
        };

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(task);
            threads.add(thread);
            thread.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        int result = incrementInteger.get();
        log(incrementInteger.getClass().getSimpleName() + " : " + result);
    }
}
