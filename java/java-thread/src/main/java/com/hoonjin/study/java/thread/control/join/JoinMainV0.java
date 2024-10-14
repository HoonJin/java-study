package com.hoonjin.study.java.thread.control.join;

import static com.hoonjin.study.java.util.MyLogger.log;
import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class JoinMainV0 {

    public static void main(String[] args) {
        log("Start");

        Runnable job = () -> {
            log("job start");
            sleep(2000);
            log("job end");
        };

        Thread thread0 = new Thread(job, "thread-0");
        Thread thread1 = new Thread(job, "thread-1");

        thread0.start();
        thread1.start();

        log("End");
    }
}
