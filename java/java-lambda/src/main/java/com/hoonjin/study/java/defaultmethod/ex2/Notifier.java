package com.hoonjin.study.java.defaultmethod.ex2;

import java.time.LocalDateTime;

public interface Notifier {

    void notify(String message);

    // 신규 기능 추가
    default void scheduleNotification(String message, LocalDateTime scheduledTime) {
        System.out.println("[SCHEDULED] message = " + message + " at " + scheduledTime);
        notify(message);
    }
}
