package com.hoonjin.study.java.ionetwork.network.tcp.v5;

import lombok.RequiredArgsConstructor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static com.hoonjin.study.java.util.MyLogger.log;

@RequiredArgsConstructor
public class SessionV5 implements Runnable {

    private final Socket socket;

    @Override
    public void run() {
        try (socket;
             DataInputStream dis = new DataInputStream(socket.getInputStream());
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {
            log("connect socket: " + socket);

            while (true) {
                String received = dis.readUTF();
                log("client -> server: " + received);

                if (received.equals("exit")) {
                    log("close session");
                    break;
                }

                String toSend = received + " World!";
                dos.writeUTF(toSend);
                log("client <- server: " + toSend);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        log("socket is closed: " + socket.isClosed());
    }
}
