package com.hoonjin.study.java.ionetwork.was.v3;

import lombok.RequiredArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URLDecoder;

import static com.hoonjin.study.java.util.MyLogger.log;
import static java.nio.charset.StandardCharsets.UTF_8;

@RequiredArgsConstructor
public class HttpRequestHandlerV3 implements Runnable {

    private final Socket socket;

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

            String request = requestToString(reader);
            if (request.contains("/favicon.ico")) {
                return;
            }

            if (request.startsWith("GET /site1")) {
                site1(writer);
            } else if (request.startsWith("GET /site2")) {
                site2(writer);
            } else if (request.startsWith("GET /search")) {
                search(writer, request);
            } else if (request.startsWith("GET / ")) {
                home(writer);
            } else {
                notFound(writer);
            }
        }
    }

    private void home(PrintWriter writer) {
        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-Type: text/html; charset=UTF-8");
        writer.println();
        writer.println("<h1>home</h1>");
        writer.println("<ul>");
        writer.println("<li><a href='/site1'>site1</a></li>");
        writer.println("<li><a href='/site1'>site2</a></li>");
        writer.println("<li><a href='/search?q=hello'>search</a></li>");
        writer.println("</ul>");
        writer.flush();
    }

    private void site1(PrintWriter writer) {
        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-Type: text/html; charset=UTF-8");
        writer.println();
        writer.println("<h1>site1</h1>");
        writer.flush();
    }

    private void site2(PrintWriter writer) {
        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-Type: text/html; charset=UTF-8");
        writer.println();
        writer.println("<h1>site2</h1>");
        writer.flush();
    }

    private void notFound(PrintWriter writer) {
        writer.println("HTTP/1.1 404 Not Found");
        writer.println("Content-Type: text/html; charset=UTF-8");
        writer.println();
        writer.println("<h1>페이지를 찾을 수 없습니다.</h1>");
        writer.flush();
    }

    // "/search?q=hello"
    private void search(PrintWriter writer, String request) {
        int startIdx = request.indexOf("q=");
        int endIdx = request.indexOf(" ", startIdx + 2);
        String query = request.substring(startIdx + 2, endIdx);
        String decode = URLDecoder.decode(query, UTF_8);

        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-Type: text/html; charset=UTF-8");
        writer.println();
        writer.println("<h1>search</h1>");
        writer.println("<ul>");
        writer.println("<li>query: " + query + "</li>");
        writer.println("<li>decode: " + decode + "</li>");
        writer.println("</ul>");

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

}
