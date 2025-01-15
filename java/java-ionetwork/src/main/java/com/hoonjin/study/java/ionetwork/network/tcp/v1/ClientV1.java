package com.hoonjin.study.java.ionetwork.network.tcp.v1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static com.hoonjin.study.java.util.MyLogger.log;

public class ClientV1 {

    private static final String SERVER = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("start client");

        try (Socket socket = new Socket(SERVER, PORT);
             DataInputStream dis = new DataInputStream(socket.getInputStream());
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {
            log("connected socket: " + socket);

            String toSend = "Hello";
            dos.writeUTF(toSend);
            log("client -> server: " + toSend);

            String received = dis.readUTF();
            log("client <- server: " + received);
        }
    }
}
