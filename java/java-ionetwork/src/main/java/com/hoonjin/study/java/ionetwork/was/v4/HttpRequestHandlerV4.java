package com.hoonjin.study.java.ionetwork.was.v4;

import com.hoonjin.study.java.ionetwork.was.httpserver.HttpRequest;
import com.hoonjin.study.java.ionetwork.was.httpserver.HttpResponse;
import lombok.RequiredArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static com.hoonjin.study.java.util.MyLogger.log;
import static java.nio.charset.StandardCharsets.UTF_8;

@RequiredArgsConstructor
public class HttpRequestHandlerV4 implements Runnable {

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

            HttpRequest request = new HttpRequest(reader);
            HttpResponse response = new HttpResponse(writer);

            if (request.getPath().contains("/favicon.ico")) {
                return;
            }

            log(request);

            if (request.getPath().equals("/site1")) {
                site1(response);
            } else if (request.getPath().equals("/site2")) {
                site2(response);
            } else if (request.getPath().equals("/search")) {
                search(request, response);
            } else if (request.getPath().equals("/")) {
                home(response);
            } else {
                notFound(response);
            }
            response.flush();
        }
    }

    private void home(HttpResponse response) {
        response.writeBody("<h1>home</h1>");
        response.writeBody("<ul>");
        response.writeBody("<li><a href='/site1'>site1</a></li>");
        response.writeBody("<li><a href='/site1'>site2</a></li>");
        response.writeBody("<li><a href='/search?q=hello'>search</a></li>");
        response.writeBody("</ul>");
    }

    private void site1(HttpResponse response) {
        response.writeBody("<h1>site1</h1>");
    }

    private void site2(HttpResponse response) {
        response.writeBody("<h1>site2</h1>");
    }

    // "/search?q=hello"
    private void search(HttpRequest request, HttpResponse response) {
        String query = request.getParameter("q");
        response.writeBody("<h1>search</h1>");
        response.writeBody("<ul>");
        response.writeBody("<li>query: " + query + "</li>");
//        response.writeBody("<li>decode: " + decode + "</li>");
        response.writeBody("</ul>");
    }

    private void notFound(HttpResponse response) {
        response.setStatusCode(404);
        response.writeBody("<h1>페이지를 찾을 수 없습니다.</h1>");
    }
}
