package com.hoonjin.study.java.thread.cas.increment;

public class BasicIncrementInteger implements IncrementInteger {

    private int value;

    @Override
    public void increment() {
        value++;
    }

    @Override
    public int get() {
        return value;
    }
}
