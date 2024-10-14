package com.hoonjin.study.java.thread.control.join;

import static com.hoonjin.study.java.util.MyLogger.log;
import static com.hoonjin.study.java.util.ThreadUtils.sleep;

class SumTask implements Runnable {
    int startValue;
    int endValue;
    int result;

    SumTask(int startValue, int endValue) {
        this.startValue = startValue;
        this.endValue = endValue;
    }

    @Override
    public void run() {
        sleep(1000);
        for (int i = startValue; i <= endValue; i++) {
            result += i;
        }
        log("result = " + result);
    }
}
