package com.hoonjin.study.java.ionetwork.network.tcp.v3;

import lombok.RequiredArgsConstructor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static com.hoonjin.study.java.util.MyLogger.log;

@RequiredArgsConstructor
public class SessionV3 implements Runnable {

    private final Socket socket;

    @Override
    public void run() {
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            log("connect socket: " + socket);

            while (true) {
                String received = dis.readUTF();
                log("client -> server: " + received);

                if (received.equals("exit")) {
                    log("close server");
                    break;
                }

                String toSend = received + " World!";
                dos.writeUTF(toSend);
                log("client <- server: " + toSend);
            }

            // 서버 종료시 기존 연결되어있는 클라이언트의 자원을 제대로 정리하지 못하는 문제가 있음
            dis.close();
            dos.close();
            log("close socket: " + socket);
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
