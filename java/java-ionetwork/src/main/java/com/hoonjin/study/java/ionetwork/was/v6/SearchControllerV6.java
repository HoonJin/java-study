package com.hoonjin.study.java.ionetwork.was.v6;

import com.hoonjin.study.java.ionetwork.was.httpserver.HttpRequest;
import com.hoonjin.study.java.ionetwork.was.httpserver.HttpResponse;

public class SearchControllerV6 {

    public void search(HttpRequest request, HttpResponse response) {
        String query = request.getParameter("q");
        response.writeBody("<h1>search</h1>");
        response.writeBody("<ul>");
        response.writeBody("<li>query: " + query + "</li>");
        response.writeBody("</ul>");
    }
}
