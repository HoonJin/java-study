package com.hoonjin.study.java.ionetwork.network.chat.client;

import java.io.IOException;
import java.net.Socket;

public class ChatClient {

    private static final String SERVER = "localhost";
    private static final int PORT = 23456;

    public static void main(String[] args) throws IOException, InterruptedException {
        try (Socket socket = new Socket(SERVER, PORT)) {
            Thread messageHandler = new Thread(new MessageHandler(socket));
            Thread messageSender = new Thread(new MessageSender(socket));

            messageHandler.start();
            messageSender.start();

            messageSender.join();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
