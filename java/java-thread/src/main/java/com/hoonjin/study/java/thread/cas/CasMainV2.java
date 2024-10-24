package com.hoonjin.study.java.thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

import static com.hoonjin.study.java.util.MyLogger.log;

public class CasMainV2 {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();

        int resultValue = incrementAndGet(atomicInteger);
        log("resultValue = " + resultValue);
    }

    private static int incrementAndGet(AtomicInteger atomicInteger) {
        int getValue;
        boolean result;
        do {
            getValue = atomicInteger.get();
            log("getValue = " + getValue);
            result = atomicInteger.compareAndSet(getValue, getValue + 1);
            log("result = " + result);
        } while (!result);
        return getValue + 1;
    }
}
