package com.hoonjin.study.java.ionetwork.chat.server.command;

import com.hoonjin.study.java.ionetwork.chat.server.Session;

import java.io.IOException;

public interface Command {

    void execute(String[] args, Session session) throws IOException;

}
