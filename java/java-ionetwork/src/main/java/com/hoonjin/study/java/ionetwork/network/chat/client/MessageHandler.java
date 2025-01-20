package com.hoonjin.study.java.ionetwork.network.chat.client;

import lombok.RequiredArgsConstructor;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import static com.hoonjin.study.java.util.MyLogger.log;

@RequiredArgsConstructor
public class MessageHandler implements Runnable {

    private final Socket socket;

    @Override
    public void run() {
        try (DataInputStream dis = new DataInputStream(socket.getInputStream())) {
            while (true) {
                String msg = dis.readUTF();
                log(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
