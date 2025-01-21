package com.hoonjin.study.java.ionetwork.chat.client;

import java.io.IOException;

public class ClientMain {

    private static final int PORT = 23456;

    public static void main(String[] args) throws IOException {
        Client client = new Client("localhost", PORT);
        client.start();
    }
}
