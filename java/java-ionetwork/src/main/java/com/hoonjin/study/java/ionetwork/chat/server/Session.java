package com.hoonjin.study.java.ionetwork.chat.server;

import lombok.Getter;
import lombok.Setter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static com.hoonjin.study.java.ionetwork.network.tcp.SocketCloseUtil.closeAll;
import static com.hoonjin.study.java.util.MyLogger.log;

public class Session implements Runnable {

    private final Socket socket;
    private final DataInputStream dis;
    private final DataOutputStream dos;
    private final CommandManager commandManager;
    private final SessionManager sessionManager;

    private boolean closed = false;

    @Setter
    @Getter
    private String username;

    public Session(Socket socket, CommandManager commandManager, SessionManager sessionManager) throws IOException {
        this.socket = socket;
        this.dis = new DataInputStream(socket.getInputStream());
        this.dos = new DataOutputStream(socket.getOutputStream());
        this.commandManager = commandManager;
        this.sessionManager = sessionManager;
        sessionManager.add(this);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String received = dis.readUTF();
                log("client -> server: " + received);

                commandManager.execute(received, this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sessionManager.remove(this);
            sessionManager.sendAll(username + "님이 퇴장했습니다.");
            close();
        }
    }

    public void send(String message) throws IOException {
        log("server -> client: " + message);
        dos.writeUTF(message);
    }

    public void close() {
        if (closed) {
            return;
        }

        closeAll(socket, dis, dos);
        closed = true;
        log("connection closed");
    }
}
