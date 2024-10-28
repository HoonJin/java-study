package com.hoonjin.study.java.thread.collection.simple.list;

public class SyncProxyList implements SimpleList {

    private SimpleList target;

    public SyncProxyList(SimpleList target) {
        this.target = target;
    }

    @Override
    public synchronized int size() {
        return target.size();
    }

    @Override
    public synchronized void add(Object o) {
        target.add(o);
    }

    @Override
    public synchronized Object get(int i) {
        return target.get(i);
    }

    @Override
    public synchronized String toString() {
        return target.toString() + " by " + getClass().getSimpleName();
    }
}
