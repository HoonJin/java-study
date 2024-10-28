package com.hoonjin.study.java.thread.collection.simple.list;

import java.util.Arrays;

import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class BasicList implements SimpleList {

    private static final int CAPACITY = 5;

    private final Object[] elements;
    private int size = 0;

    public BasicList() {
        this.elements = new Object[CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(Object o) {
        elements[size] = o;
        sleep(1);
        size++;
    }

    @Override
    public Object get(int i) {
        return elements[i];
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elements, size)) + " size = " + size;
    }
}
