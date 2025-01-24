package com.hoonjin.study.java.ionetwork.was.v5.servlet;

import com.hoonjin.study.java.ionetwork.was.httpserver.HttpRequest;
import com.hoonjin.study.java.ionetwork.was.httpserver.HttpResponse;
import com.hoonjin.study.java.ionetwork.was.httpserver.HttpServlet;

public class HomeServlet implements HttpServlet {
    @Override
    public void service(HttpRequest request, HttpResponse response) {
        response.writeBody("<h1>home</h1>");
        response.writeBody("<ul>");
        response.writeBody("<li><a href='/site1'>site1</a></li>");
        response.writeBody("<li><a href='/site1'>site2</a></li>");
        response.writeBody("<li><a href='/search?q=hello'>search</a></li>");
        response.writeBody("</ul>");
    }
}
