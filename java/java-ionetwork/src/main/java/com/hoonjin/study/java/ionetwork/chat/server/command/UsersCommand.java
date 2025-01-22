package com.hoonjin.study.java.ionetwork.chat.server.command;

import com.hoonjin.study.java.ionetwork.chat.server.Session;
import com.hoonjin.study.java.ionetwork.chat.server.SessionManager;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class UsersCommand implements Command {

    private final SessionManager sessionManager;

    @Override
    public void execute(String[] args, Session session) throws IOException {
        List<String> allUsername = sessionManager.getAllUsername();
        int size = allUsername.size();
        String names = String.join(" - ", allUsername);
        session.send("전체 접속자 : " + size + "\n" + names + "\n");
    }
}
