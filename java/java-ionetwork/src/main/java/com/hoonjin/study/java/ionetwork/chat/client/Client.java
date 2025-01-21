package com.hoonjin.study.java.ionetwork.chat.client;

import lombok.Getter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static com.hoonjin.study.java.ionetwork.network.tcp.SocketCloseUtil.closeAll;
import static com.hoonjin.study.java.util.MyLogger.log;

public class Client {

    private final String host;
    private final int port;
    private Socket socket;
    private DataOutputStream dos;
    private DataInputStream dis;

    private ReadHandler readHandler;
    private WriteHandler writeHandler;

    @Getter
    private boolean closed = false;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws IOException {
        log("start client");
        socket = new Socket(host, port);
        dos = new DataOutputStream(socket.getOutputStream());
        dis = new DataInputStream(socket.getInputStream());

        readHandler = new ReadHandler(dis, this);
        writeHandler = new WriteHandler(dos, this);

        Thread readThread = new Thread(readHandler, "readHandler");
        Thread writeThread = new Thread(writeHandler, "writeHandler");
        readThread.start();
        writeThread.start();
    }

    public synchronized void close() {
        if (closed) {
            return;
        }

        writeHandler.close();
        readHandler.close();
        closeAll(socket, dis, dos);
        closed = true;
        log("closed client");
    }
}
