package com.hoonjin.study.java.basic.poly.ex.sender;

public class FaceBookSender implements Sender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Send Facebook Message: " + message);
    }
}
