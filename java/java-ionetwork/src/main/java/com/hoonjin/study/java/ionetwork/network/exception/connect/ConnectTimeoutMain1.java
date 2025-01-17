package com.hoonjin.study.java.ionetwork.network.exception.connect;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class ConnectTimeoutMain1 {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        try (Socket socket = new Socket("192.168.1.250", 45678)) {

        } catch (ConnectException e) {
            // windows 21 sec
            // linux 75 ~ 180 sec
            // mac 75 sec
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
