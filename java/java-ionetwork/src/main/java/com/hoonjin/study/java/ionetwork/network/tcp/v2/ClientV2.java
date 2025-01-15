package com.hoonjin.study.java.ionetwork.network.tcp.v2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static com.hoonjin.study.java.util.MyLogger.log;

public class ClientV2 {

    private static final String SERVER = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("start client");

        try (Socket socket = new Socket(SERVER, PORT);
             DataInputStream dis = new DataInputStream(socket.getInputStream());
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {
            log("connected socket: " + socket);

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("전송 문자: ");
                String toSend = scanner.nextLine();
                dos.writeUTF(toSend);
                log("client -> server: " + toSend);

                if (toSend.equals("exit")) {
                    break;
                }

                String received = dis.readUTF();
                log("client <- server: " + received);
            }
        }
    }
}
