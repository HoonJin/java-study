package com.hoonjin.study.java.thread.start;

import static com.hoonjin.study.java.util.MyLogger.log;

public class InnerRunnableMainV2 {

    public static void main(String[] args) {
        log("main() start");

        Thread thread = new Thread(() -> {
            log("run()");
        });
        thread.start();

        log("main() end");
    }
}
