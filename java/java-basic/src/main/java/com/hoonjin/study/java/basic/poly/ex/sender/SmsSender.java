package com.hoonjin.study.java.basic.poly.ex.sender;

public class SmsSender implements Sender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Send SMS: " + message);
    }
}
