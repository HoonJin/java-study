package com.hoonjin.study.java.basic.poly.ex.sender;

public class EmailSender implements Sender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Send Email: " + message);
    }
}
