package com.hoonjin.study.java.was.v7;

import com.hoonjin.study.java.was.httpserver.HttpRequest;
import com.hoonjin.study.java.was.httpserver.HttpResponse;
import com.hoonjin.study.java.was.httpserver.annotation.Mapping;

public class SearchControllerV7 {

    @Mapping("/search")
    public void search(HttpRequest request, HttpResponse response) {
        String query = request.getParameter("q");
        response.writeBody("<h1>search</h1>");
        response.writeBody("<ul>");
        response.writeBody("<li>query: " + query + "</li>");
        response.writeBody("</ul>");
    }
}
