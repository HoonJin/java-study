package com.hoonjin.study.java.ionetwork.chat.server;

import com.hoonjin.study.java.ionetwork.chat.server.command.*;

import java.io.IOException;
import java.util.Map;

public class CommandManagerV3 implements CommandManager {

    private static final String DELIMITER = "\\|";
    private final Map<String, Command> commands;
    private final Command defaultCommand = new DefaultCommand();

    public CommandManagerV3(SessionManager sessionManager) {
        commands = Map.of(
            "/join", new JoinCommand(sessionManager),
            "/message", new MessageCommand(sessionManager),
            "/change", new ChangeCommand(sessionManager),
            "/users", new UsersCommand(sessionManager),
            "/exit", new ExitCommand()
        );
    }

    @Override
    public void execute(String totalMessage, Session session) throws IOException {
        String[] args = totalMessage.split(DELIMITER);
        String key = args[0];

//        Command command = commands.get(key);
//        if (command != null) {
//            command.execute(args, session);
//        } else {
//            session.send("처리할 수 없는 명령어입니다.");
//        }
        // nullObject pattern
        commands.getOrDefault(key, defaultCommand)
            .execute(args, session);
    }
}
