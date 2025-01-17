package com.hoonjin.study.java.ionetwork.network.exception.connect;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ConnectTimeoutMain2 {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        try (Socket socket = new Socket()) {
            InetSocketAddress address = new InetSocketAddress("192.168.1.250", 45678);
            socket.connect(address, 3000);
        } catch (SocketTimeoutException e) {
            e.printStackTrace(); // java.net.SocketTimeoutException: Connect timed out
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
