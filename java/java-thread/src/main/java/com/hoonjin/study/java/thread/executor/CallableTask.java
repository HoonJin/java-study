package com.hoonjin.study.java.thread.executor;

import java.util.Random;
import java.util.concurrent.Callable;

import static com.hoonjin.study.java.util.MyLogger.log;
import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class CallableTask implements Callable<Integer> {

    private final String name;
    private final int sleepMs;

    public CallableTask(String name) {
        this.name = name;
        this.sleepMs = 1000;
    }

    public CallableTask(String name, int sleepMs) {
        this.name = name;
        this.sleepMs = sleepMs;
    }
    @Override
    public Integer call() throws Exception {
        log(name + " 시작");
        sleep(sleepMs);
        log(name + " 완료");
        return new Random().nextInt(10);
    }
}
