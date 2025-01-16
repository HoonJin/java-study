package com.hoonjin.study.java.ionetwork.network.tcp.v6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static com.hoonjin.study.java.ionetwork.network.tcp.SocketCloseUtil.closeAll;
import static com.hoonjin.study.java.util.MyLogger.log;

public class SessionV6 implements Runnable {

    private final Socket socket;
    private final DataInputStream dis;
    private final DataOutputStream dos;
    private final SessionManagerV6 sessionManager;

    private boolean closed = false;

    public SessionV6(Socket socket, SessionManagerV6 sessionManager) throws IOException {
        this.socket = socket;
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
        this.sessionManager = sessionManager;
        this.sessionManager.add(this);

        log("connect socket: " + socket);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String received = dis.readUTF();
                log("client -> server: " + received);

                if (received.equals("exit")) {
                    log("close session");
                    break;
                }

                String toSend = received + " World!";
                dos.writeUTF(toSend);
                log("client <- server: " + toSend);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            sessionManager.remove(this);
            close();
        }
    }

    public synchronized void close() {
        if (!closed) {
            closeAll(socket, dis, dos);
            closed = true;
            log("socket" + socket + " is closed: " + socket.isClosed());
        }
    }
}
