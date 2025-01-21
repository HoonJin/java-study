package com.hoonjin.study.java.ionetwork.chat.server;

import java.io.IOException;

public class ServerMain {

    private static final int port = 23456;

    public static void main(String[] args) throws IOException {
        SessionManager sessionManager = new SessionManager();
        CommandManager commandManager = new CommandManagerV1(sessionManager);

        Server server = new Server(port, commandManager, sessionManager);
        server.start();
    }
}
