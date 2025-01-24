package com.hoonjin.study.java.ionetwork.was.httpserver;

import lombok.RequiredArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static com.hoonjin.study.java.util.MyLogger.log;
import static java.nio.charset.StandardCharsets.UTF_8;

@RequiredArgsConstructor
public class HttpRequestHandler implements Runnable {

    private final Socket socket;
    private final ServletManager servletManager;

    @Override
    public void run() {
        try {
            process();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void process() throws IOException {
        try (socket;
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), UTF_8));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), false, UTF_8)) {

            HttpRequest request = new HttpRequest(reader);
            HttpResponse response = new HttpResponse(writer);

            log(request);
            servletManager.execute(request, response);
        }
    }
}
