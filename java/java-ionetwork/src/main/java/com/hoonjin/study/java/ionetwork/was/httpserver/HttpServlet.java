package com.hoonjin.study.java.ionetwork.was.httpserver;

import java.io.IOException;

public interface HttpServlet {

    void service(HttpRequest request, HttpResponse response) throws IOException;
}
