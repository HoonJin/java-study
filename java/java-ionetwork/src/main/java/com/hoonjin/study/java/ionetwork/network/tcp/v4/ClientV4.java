package com.hoonjin.study.java.ionetwork.network.tcp.v4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static com.hoonjin.study.java.ionetwork.network.tcp.SocketCloseUtil.closeAll;
import static com.hoonjin.study.java.util.MyLogger.log;

public class ClientV4 {

    private static final String SERVER = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("start client");

        // finally 블록에서 접근해야하기 때문에 선언해야 한다. v1, v2 client 가 더 좋은 방법
        Socket socket = null;
        DataInputStream dis = null;
        DataOutputStream dos = null;
        try {
            socket = new Socket(SERVER, PORT);
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
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
        } catch (IOException e) {
            log(e);
        } finally {
            closeAll(socket, dis, dos);
            log("closed socket: " + socket);
        }
    }
}
