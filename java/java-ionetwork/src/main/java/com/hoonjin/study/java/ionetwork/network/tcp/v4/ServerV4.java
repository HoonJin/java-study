package com.hoonjin.study.java.ionetwork.network.tcp.v4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static com.hoonjin.study.java.util.MyLogger.log;

public class ServerV4 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("start server");
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("socket started, listening port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();

            SessionV4 session = new SessionV4(socket);
            Thread thread = new Thread(session);
            thread.start();
        }

//        serverSocket.close();
    }
}
