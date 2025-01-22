package com.hoonjin.study.java.ionetwork.chat.server.command;

import com.hoonjin.study.java.ionetwork.chat.server.Session;
import com.hoonjin.study.java.ionetwork.chat.server.SessionManager;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

@RequiredArgsConstructor
public class MessageCommand implements Command {

    private final SessionManager sessionManager;

    @Override
    public void execute(String[] args, Session session) throws IOException {
        String message = args[1];
        sessionManager.sendAll("[" + session.getUsername() + "] " + message);
    }
}
