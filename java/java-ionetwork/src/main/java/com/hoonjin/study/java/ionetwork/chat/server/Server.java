package com.hoonjin.study.java.ionetwork.chat.server;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static com.hoonjin.study.java.util.MyLogger.log;

@RequiredArgsConstructor
public class Server {

    private final int port;
    private final CommandManager commandManager;
    private final SessionManager sessionManager;

    private ServerSocket serverSocket;

    public void start() throws IOException {
        log("server started: " + commandManager.getClass());
        serverSocket = new ServerSocket(port);

        addShutdownHook();
        running();
    }

    private void running() {
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                log("socket connected: " + socket);
                Session session = new Session(socket, commandManager, sessionManager);
                Thread thread = new Thread(session);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addShutdownHook() {
        ShutdownHook target = new ShutdownHook(serverSocket, sessionManager);
        Runtime.getRuntime().addShutdownHook(new Thread(target));
    }


    @RequiredArgsConstructor
    static class ShutdownHook implements Runnable {

        private final ServerSocket serverSocket;
        private final SessionManager sessionManager;

        @Override
        public void run() {
            log("execute shutdown hook");
            try {
                sessionManager.closeAll();
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
