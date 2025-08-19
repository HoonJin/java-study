package com.hoonjin.study.java.defaultmethod.ex1;

import java.util.List;

public class NotifierMainV1 {

    public static void main(String[] args) {
        List<Notifier> notifiers = List.of(
            new EmailNotifier(),
            new SmsNotifier(),
            new AppPushNotifier()
        );

//        for (Notifier notifier : notifiers) {
//            notifier.notify("Hello, World!");
//        }
        notifiers.forEach(notifier -> notifier.notify("Hello, World!"));
    }
}
