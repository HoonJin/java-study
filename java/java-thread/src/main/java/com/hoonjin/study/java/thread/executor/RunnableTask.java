package com.hoonjin.study.java.thread.executor;

import static com.hoonjin.study.java.util.MyLogger.log;
import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class RunnableTask implements Runnable {

    private final String name;
    private final int sleepMs;

    public RunnableTask(String name) {
        this.name = name;
        this.sleepMs = 1000;
    }

    public RunnableTask(String name, int sleepMs) {
        this.name = name;
        this.sleepMs = sleepMs;
    }

    @Override
    public void run() {
        log(name + " 시작");
        sleep(sleepMs);
        log(name + " 완료");

    }
}
