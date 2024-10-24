package com.hoonjin.study.java.thread.cas.increment;

public class SyncIncrementInteger implements IncrementInteger {

    private int value;

    @Override
    public synchronized void increment() {
        value++;
    }

    @Override
    public synchronized int get() {
        return value;
    }
}
