package com.hoonjin.study.java.thread.cas.increment;

public class VolatileIncrementInteger implements IncrementInteger {

    volatile private int value;

    @Override
    public void increment() {
        // 잘못된 코드
        value++;
    }

    @Override
    public int get() {
        return value;
    }
}
