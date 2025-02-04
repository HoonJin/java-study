package com.hoonjin.study.java.was.v3;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.hoonjin.study.java.util.MyLogger.log;

@RequiredArgsConstructor
public class HttpServerV3 {

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
    private final int port;

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            log("v2 start server: " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                HttpRequestHandlerV3 handler = new HttpRequestHandlerV3(socket);
                executorService.submit(handler);
            }
        }
    }
}
