package com.hoonjin.study.java.ionetwork.was.httpserver;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.hoonjin.study.java.util.MyLogger.log;

@RequiredArgsConstructor
public class HttpServer {

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
    private final int port;
    private final ServletManager servletManager;

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            log("start http server: " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                HttpRequestHandler handler = new HttpRequestHandler(socket, servletManager);
                executorService.submit(handler);
            }
        }
    }
}
