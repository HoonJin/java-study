package com.hoonjin.study.java.ionetwork.network.chat.server;

import com.hoonjin.study.java.ionetwork.network.chat.Command;
import lombok.Getter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatSession implements Runnable {

    private static final String DELIMITER = "\\|";

    private final Socket socket;
    private final SessionManager sessionManager;
    private final DataOutputStream dos;
    private final DataInputStream dis;

    public ChatSession(Socket socket, SessionManager sessionManager) throws IOException {
        this.socket = socket;
        this.sessionManager = sessionManager;
        System.out.println("registered " + key());
        this.dos = new DataOutputStream(socket.getOutputStream());
        this.dis = new DataInputStream(socket.getInputStream());
    }

    @Getter
    private String name;

    @Override
    public void run() {
        try {
            while (true) {
                String input = dis.readUTF();
                String[] split = input.split(DELIMITER);
                String cmd = split[0];

                if (cmd.equals(Command.EXIT.value())) {
                    sessionManager.remove(this);
                    close();
                    break;
                } else if (cmd.equals(Command.JOIN.value())) {
                    sessionManager.add(this);
                    this.name = split[1];
                    sessionManager.sendAll(name + "님이 입장하셨습니다.");
                } else if (cmd.equals(Command.CHANGE.value())) {
                    String old = name;
                    this.name = split[0];
                    sessionManager.sendAll(old + "님 이름이 " + name + "으/로 변경되었습니다.");
                } else if (cmd.equals(Command.MESSAGE.value())) {
                    String msg = split[1];
                    sessionManager.sendAll(name + ": " + msg);
                } else if (cmd.equals(Command.USERS.value())) {
                    String msg = String.join(", ", sessionManager.getAllUserName());
                    dos.writeUTF(msg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg) {
        try {
            dos.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String key() {
        return socket.getInetAddress() + ":" + socket.getPort();
    }

    public void close() {
        try {
            dos.close();
            dis.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
