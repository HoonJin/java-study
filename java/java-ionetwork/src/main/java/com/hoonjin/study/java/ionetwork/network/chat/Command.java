package com.hoonjin.study.java.ionetwork.network.chat;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Command {
    JOIN("/join"),
    MESSAGE("/message"),
    CHANGE("/change"),
    USERS("/users"),
    EXIT("/exit")
    ;

    private final String value;

    public String value() {
        return value;
    }
}
