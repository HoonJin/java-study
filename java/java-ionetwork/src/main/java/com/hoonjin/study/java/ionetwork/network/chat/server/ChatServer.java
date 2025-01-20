package com.hoonjin.study.java.ionetwork.network.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    private static final int PORT = 23456;

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = serverSocket.accept();
                ChatSession chatSession = new ChatSession(socket, sessionManager);
                Thread thread = new Thread(chatSession);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sessionManager.closeAll();
        }
    }
}
