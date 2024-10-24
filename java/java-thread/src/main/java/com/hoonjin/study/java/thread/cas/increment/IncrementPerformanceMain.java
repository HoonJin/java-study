package com.hoonjin.study.java.thread.cas.increment;

import static com.hoonjin.study.java.util.MyLogger.log;

public class IncrementPerformanceMain {

    private static final long CNT = 100_000_000;

    public static void main(String[] args) {
        test(new BasicIncrementInteger());
        test(new VolatileIncrementInteger());
        test(new SyncIncrementInteger());
        test(new MyAtomicIncrementInteger());
    }

    private static void test(IncrementInteger incrementInteger) {
        long startMs = System.currentTimeMillis();

        for (int i = 0; i < CNT; i++) {
            incrementInteger.increment();
        }

        long endMs = System.currentTimeMillis();
        log(incrementInteger.getClass().getSimpleName() + " : " + (endMs - startMs) + "ms");
    }
}
