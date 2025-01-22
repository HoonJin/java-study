package com.hoonjin.study.java.ionetwork.chat.server;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class CommandManagerV2 implements CommandManager {

    private static final String DELIMITER = "\\|";
    private final SessionManager sessionManager;

    @Override
    public void execute(String totalMessage, Session session) throws IOException {
        if (totalMessage.startsWith("/join")) {
            String[] split = totalMessage.split(DELIMITER);
            String username = split[1];
            session.setUsername(username);
            sessionManager.sendAll(username + "님이 입장했습니다.");
        } else if (totalMessage.startsWith("/message")) {
            String[] split = totalMessage.split(DELIMITER);
            String message = split[1];
            sessionManager.sendAll("[" + session.getUsername() + "] " + message);
        } else if (totalMessage.startsWith("/change")) {
            String[] split = totalMessage.split(DELIMITER);
            String username = split[1];
            sessionManager.sendAll(session.getUsername() + "님이 " + username + "으/로 이름을 변경했습니다.");
            session.setUsername(username);
        } else if (totalMessage.startsWith("/users")) {
            List<String> allUsername = sessionManager.getAllUsername();
            int size = allUsername.size();
            String names = String.join(" - ", allUsername);
            session.send("전체 접속자 : " + size + "\n" + names + "\n");
        } else if (totalMessage.startsWith("/exit")) {
            throw new IOException("exit");
        } else {
            session.send("처리할 수 없는 명령어입니다.");
        }
    }
}
