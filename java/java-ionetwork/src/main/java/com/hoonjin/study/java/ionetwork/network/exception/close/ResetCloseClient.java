package com.hoonjin.study.java.ionetwork.network.exception.close;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

import static com.hoonjin.study.java.util.MyLogger.log;

public class ResetCloseClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 12345);
        log("socket = " + socket);

        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        // client <- server: FIN
        Thread.sleep(1000);

        // client -> server: PUSH[1]
        os.write(1);

        // client <- server: RST
        Thread.sleep(1000); // RST 메시지 대기

        try {
            int read = is.read();
            System.out.println("read = " + read);
        } catch (SocketException e) {
            e.printStackTrace();
            // java.net.SocketException: Connection reset // 이미 RST 메시지를 받았다
        }

        try {
            os.write(2);
        } catch (SocketException e) {
            e.printStackTrace();
            // java.net.SocketException: Broken pipe // 이미 끝난 커넥션에 보냈다
        }

        log("closed: " + socket.isClosed());

        os.close();
        is.close();
        socket.close();

        log("closed: " + socket.isClosed());

    }
}
