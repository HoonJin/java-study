package com.hoonjin.study.java.thread.cas.increment;

import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomicIncrementInteger implements IncrementInteger {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void increment() {
        atomicInteger.incrementAndGet();
    }

    @Override
    public int get() {
        return atomicInteger.get();
    }
}
