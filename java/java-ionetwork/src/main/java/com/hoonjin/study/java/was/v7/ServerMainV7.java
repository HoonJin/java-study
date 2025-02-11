package com.hoonjin.study.java.was.v7;

import com.hoonjin.study.java.was.httpserver.HttpServer;
import com.hoonjin.study.java.was.httpserver.HttpServlet;
import com.hoonjin.study.java.was.httpserver.ServletManager;
import com.hoonjin.study.java.was.httpserver.annotation.AnnotationServletV1;
import com.hoonjin.study.java.was.httpserver.servlet.DiscardServlet;

import java.io.IOException;
import java.util.List;

public class ServerMainV7 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        List<Object> controllers = List.of(new SiteControllerV7(), new SearchControllerV7());
        HttpServlet annotationServlet = new AnnotationServletV1(controllers);

        ServletManager servletManager = new ServletManager();
        servletManager.setDefaultServlet(annotationServlet);
        servletManager.add("/favicon.ico", new DiscardServlet());

        HttpServer httpServer = new HttpServer(PORT, servletManager);
        httpServer.start();
    }
}
