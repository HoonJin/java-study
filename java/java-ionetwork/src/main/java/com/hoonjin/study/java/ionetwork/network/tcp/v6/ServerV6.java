package com.hoonjin.study.java.ionetwork.network.tcp.v6;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static com.hoonjin.study.java.util.MyLogger.log;

public class ServerV6 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("start server");
        SessionManagerV6 sessionManager = new SessionManagerV6();
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("socket started, listening port: " + PORT);

        ShutdownHook shutdownHook = new ShutdownHook(serverSocket, sessionManager);
        System.out.println("Runtime.getRuntime() = " + Runtime.getRuntime());
        Runtime.getRuntime().addShutdownHook(new Thread(shutdownHook, "shutdown-hook"));

        try {
            while (true) {
                Socket socket = serverSocket.accept();

                SessionV6 session = new SessionV6(socket, sessionManager);
                Thread thread = new Thread(session);
                thread.start();
            }
        } catch (IOException e) {
            log("closed server socket: " + serverSocket);
        }
    }

    @RequiredArgsConstructor
    static class ShutdownHook implements Runnable {

        private final ServerSocket serverSocket;
        private final SessionManagerV6 sessionManagerV6;

        @Override
        public void run() {
            log("execute shutdown hook");
            try {
                sessionManagerV6.closeAll();
                serverSocket.close();

                Thread.sleep(1000); // 자원정리 대기
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("IO = " + e);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Interrupted = " + e);
            }
        }
    }
}
