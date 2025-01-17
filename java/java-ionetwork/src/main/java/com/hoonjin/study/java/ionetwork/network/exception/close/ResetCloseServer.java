package com.hoonjin.study.java.ionetwork.network.exception.close;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static com.hoonjin.study.java.util.MyLogger.log;

public class ResetCloseServer {

    public static void main(String[] args) throws InterruptedException, IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        Socket socket = serverSocket.accept();

        log("socket = " + socket);

        Thread.sleep(1000);
        socket.close();
        log("socket closed = " + socket);
        serverSocket.close();
    }
}
