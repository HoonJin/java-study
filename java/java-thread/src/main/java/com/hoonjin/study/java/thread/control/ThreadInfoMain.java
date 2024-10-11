package com.hoonjin.study.java.thread.control;

import static com.hoonjin.study.java.util.MyLogger.log;

public class ThreadInfoMain {

    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        log("mainThread = " + mainThread);
        log("mainThread.threadId() = " + mainThread.threadId());
        log("mainThread.getName() = " + mainThread.getName());
        log("mainThread.getPriority() = " + mainThread.getPriority());
        log("mainThread.getThreadGroup() = " + mainThread.getThreadGroup());
        log("mainThread.getState() = " + mainThread.getState());

        Thread myThread = new Thread(() -> log("hello"), "myThread");
        log("mainThread = " + myThread);
        log("mainThread.threadId() = " + myThread.threadId());
        log("mainThread.getName() = " + myThread.getName());
        log("mainThread.getPriority() = " + myThread.getPriority());
        log("mainThread.getThreadGroup() = " + myThread.getThreadGroup());
        log("mainThread.getState() = " + myThread.getState());
    }
}
