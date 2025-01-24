package com.hoonjin.study.java.ionetwork.was.v5.servlet;

import com.hoonjin.study.java.ionetwork.was.httpserver.HttpRequest;
import com.hoonjin.study.java.ionetwork.was.httpserver.HttpResponse;
import com.hoonjin.study.java.ionetwork.was.httpserver.HttpServlet;

import java.io.IOException;

public class Site1Servlet implements HttpServlet {
    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        response.writeBody("<h1>site1</h1>");
    }
}
