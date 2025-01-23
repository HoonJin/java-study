package com.hoonjin.study.java.ionetwork.was.v1;

import java.io.IOException;

public class ServerMainV1 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        HttpServerV1 httpServer = new HttpServerV1(PORT);
        httpServer.start();
    }
}
