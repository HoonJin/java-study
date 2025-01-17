package com.hoonjin.study.java.ionetwork.network.exception.connect;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SoTimeoutClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        try (Socket socket = new Socket("localhost", 12345);
             InputStream is = socket.getInputStream()) {

            socket.setSoTimeout(5000);
            try {
                int read = is.read();
                System.out.println("read = " + read);
            } catch (Exception e) {
                e.printStackTrace(); // java.net.SocketTimeoutException: Read timed out
            }
        }
    }
}
