package com.hoonjin.study.java.ionetwork.was.v2;

import java.io.IOException;

public class ServerMainV2 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        HttpServerV2 httpServer = new HttpServerV2(PORT);
        httpServer.start();
    }
}
