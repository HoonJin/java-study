package com.hoonjin.study.java.ionetwork.network.chat.server;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SessionManager {

    private final Map<String, ChatSession> sessionMap = new ConcurrentHashMap<>();

    public void add(ChatSession session) {
        sessionMap.put(session.key(), session);
    }

    public void remove(ChatSession session) {
        session.close();
        sessionMap.remove(session.key());
    }

    public List<String> getAllUserName() {
        return sessionMap.values().stream().map(ChatSession::getName).toList();
    }

    public void sendAll(String message) {
        sessionMap.forEach((s, session) -> session.sendMessage(message));
    }

    public void closeAll() {
        sessionMap.forEach(((s, session) -> session.close()));
    }
}
