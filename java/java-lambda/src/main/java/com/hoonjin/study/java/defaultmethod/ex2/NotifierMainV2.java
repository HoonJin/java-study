package com.hoonjin.study.java.defaultmethod.ex2;

import java.time.LocalDateTime;
import java.util.List;

public class NotifierMainV2 {

    public static void main(String[] args) {
        List<Notifier> notifiers = List.of(
            new EmailNotifier(),
            new SmsNotifier(),
            new AppPushNotifier()
        );

        notifiers.forEach(notifier -> notifier.notify("Hello, World!"));

        LocalDateTime plus1Days = LocalDateTime.now().plusDays(1);
        notifiers.forEach(notifier -> notifier.scheduleNotification("good", plus1Days));
    }
}
