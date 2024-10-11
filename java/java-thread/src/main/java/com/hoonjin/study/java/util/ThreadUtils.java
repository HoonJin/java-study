package com.hoonjin.study.java.util;

import static com.hoonjin.study.java.util.MyLogger.log;

public class ThreadUtils {

    public static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            log("interrupted exception is occur." + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
