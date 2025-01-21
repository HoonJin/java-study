package com.hoonjin.study.java.ionetwork.chat.client;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.DataInputStream;
import java.io.IOException;

import static com.hoonjin.study.java.util.MyLogger.log;

@RequiredArgsConstructor
public class ReadHandler implements Runnable {

    private final DataInputStream input;
    private final Client client;

    @Getter
    private boolean closed = false;

    @Override
    public void run() {
        log("start readHandler");
        try {
            while (true) {
                String received = input.readUTF();
                log(received);
            }
        } catch (IOException e) {
            log(e);
        } finally {
            client.close();
        }

    }

    public synchronized void close() {
        if (closed) {
            return;
        }

        closed = true;
        log("closed ReadHandler");
    }
}
