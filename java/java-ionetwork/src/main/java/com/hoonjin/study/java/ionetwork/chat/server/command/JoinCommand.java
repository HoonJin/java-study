package com.hoonjin.study.java.ionetwork.chat.server.command;

import com.hoonjin.study.java.ionetwork.chat.server.Session;
import com.hoonjin.study.java.ionetwork.chat.server.SessionManager;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

@RequiredArgsConstructor
public class JoinCommand implements Command {

    private final SessionManager sessionManager;

    @Override
    public void execute(String[] args, Session session) throws IOException {
        String username = args[1];
        session.setUsername(username);
        sessionManager.sendAll(username + "님이 입장했습니다.");
    }
}
