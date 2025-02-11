package com.hoonjin.study.java.was.v9;

import com.hoonjin.study.java.was.httpserver.HttpServer;
import com.hoonjin.study.java.was.httpserver.HttpServlet;
import com.hoonjin.study.java.was.httpserver.ServletManager;
import com.hoonjin.study.java.was.httpserver.annotation.AnnotationServletV3;
import com.hoonjin.study.java.was.httpserver.servlet.DiscardServlet;
import com.hoonjin.study.java.was.v7.SearchControllerV7;
import com.hoonjin.study.java.was.v8.SiteControllerV8;

import java.io.IOException;
import java.util.List;

public class ServerMainV9 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        List<Object> controllers = List.of(new SiteControllerV8(), new SearchControllerV7());
        HttpServlet annotationServlet = new AnnotationServletV3(controllers);

        ServletManager servletManager = new ServletManager();
        servletManager.setDefaultServlet(annotationServlet);
        servletManager.add("/favicon.ico", new DiscardServlet());

        HttpServer httpServer = new HttpServer(PORT, servletManager);
        httpServer.start();
    }
}
