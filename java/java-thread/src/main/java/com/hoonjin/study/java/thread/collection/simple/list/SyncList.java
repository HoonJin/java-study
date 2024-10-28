package com.hoonjin.study.java.thread.collection.simple.list;

import java.util.Arrays;

import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class SyncList implements SimpleList {

    private static final int CAPACITY = 5;

    private final Object[] elements;
    private int size = 0;

    public SyncList() {
        this.elements = new Object[CAPACITY];
    }

    @Override
    public synchronized int size() {
        return size;
    }

    @Override
    public synchronized void add(Object o) {
        elements[size] = o;
        sleep(1);
        size++;
    }

    @Override
    public synchronized Object get(int i) {
        return elements[i];
    }

    @Override
    public synchronized String toString() {
        return Arrays.toString(Arrays.copyOf(elements, size)) + " size = " + size;
    }
}
