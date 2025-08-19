package com.hoonjin.study.java.defaultmethod.ex2;

import java.time.LocalDateTime;

public class EmailNotifier implements Notifier {
    @Override
    public void notify(String message) {
        System.out.println("[EMAIL] message = " + message);
    }

    @Override
    public void scheduleNotification(String message, LocalDateTime scheduledTime) {
        System.out.println("[EMAIL SCHEDULED] message = " + message + " at " + scheduledTime);
    }
}
