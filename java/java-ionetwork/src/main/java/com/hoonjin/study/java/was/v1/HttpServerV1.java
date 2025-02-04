package com.hoonjin.study.java.was.v1;

import lombok.RequiredArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static com.hoonjin.study.java.util.MyLogger.log;
import static java.nio.charset.StandardCharsets.UTF_8;

@RequiredArgsConstructor
public class HttpServerV1 {

    private final int port;

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            log("v1 start server: " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                process(socket);
            }
        }
    }

    private void process(Socket socket) throws IOException {
        try (socket;
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), UTF_8));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), false, UTF_8)) {

            String request = requestToString(reader);
            if (request.contains("/favicon.ico")) {
                return;
            }

            log("http request");
            System.out.println("request = " + request);

            log("generate response...");
            sleep(1000);
            responseToClient(writer);
        }
    }

    private void responseToClient(PrintWriter writer) {
        String body = "<h1>Hello World!</h1>";
        byte[] bytes = body.getBytes(UTF_8);
        int length = bytes.length;

        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 200 OK\r\n") // \r\n 캐리지 리턴 + 라인 피드
            .append("Content-Type: text/html\r\n")
            .append("Content-Length: ").append(length).append("\r\n")
            .append("\r\n")
            .append(body);

        log("http response");
        System.out.println(sb);
        writer.println(sb);
        writer.flush();
    }

    private static String requestToString(BufferedReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) { // header 의 마지막
                break;
            }
            sb.append(line).append("\n");
        }
        return sb.toString();
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
