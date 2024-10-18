package com.hoonjin.study.java.thread.sync.bounded;

public interface BoundedQueue {

    void put(String data);

    String take();
}
