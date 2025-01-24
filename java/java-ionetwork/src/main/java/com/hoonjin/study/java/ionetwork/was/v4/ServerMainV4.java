package com.hoonjin.study.java.ionetwork.was.v4;

import java.io.IOException;

public class ServerMainV4 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        HttpServerV4 httpServer = new HttpServerV4(PORT);
        httpServer.start();
    }
}
