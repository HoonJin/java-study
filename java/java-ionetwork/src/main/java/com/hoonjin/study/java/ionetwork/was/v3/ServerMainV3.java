package com.hoonjin.study.java.ionetwork.was.v3;

import java.io.IOException;

public class ServerMainV3 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        HttpServerV3 httpServer = new HttpServerV3(PORT);
        httpServer.start();
    }
}
