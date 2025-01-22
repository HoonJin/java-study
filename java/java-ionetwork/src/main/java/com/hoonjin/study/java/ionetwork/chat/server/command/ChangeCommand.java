package com.hoonjin.study.java.ionetwork.chat.server.command;

import com.hoonjin.study.java.ionetwork.chat.server.Session;
import com.hoonjin.study.java.ionetwork.chat.server.SessionManager;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

@RequiredArgsConstructor
public class ChangeCommand implements Command {

    private final SessionManager sessionManager;

    @Override
    public void execute(String[] args, Session session) throws IOException {
        String username = args[1];
        sessionManager.sendAll(session.getUsername() + "님이 " + username + "으/로 이름을 변경했습니다.");
        session.setUsername(username);
    }
}
