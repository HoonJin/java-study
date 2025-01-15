package com.hoonjin.study.java.ionetwork.network.tcp.v1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static com.hoonjin.study.java.util.MyLogger.log;

public class ServerV1 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("start server");
        try (ServerSocket serverSocket = new ServerSocket(PORT);
             Socket socket = serverSocket.accept(); // 연결이 들어올 때 까지 블로킹
             DataInputStream dis = new DataInputStream(socket.getInputStream());
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {
            log("socket started, listening port: " + PORT);
            log("connect socket: " + socket);

            String received = dis.readUTF();
            log("client -> server: " + received);

            String toSend = received + " World!";
            dos.writeUTF(toSend);
            log("client <- server: " + toSend);
        }
    }
}
