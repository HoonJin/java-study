package com.hoonjin.study.java.ionetwork.was.httpserver;

import com.hoonjin.study.java.ionetwork.was.httpserver.servlet.DiscardServlet;
import com.hoonjin.study.java.ionetwork.was.httpserver.servlet.InternalErrorServlet;
import com.hoonjin.study.java.ionetwork.was.httpserver.servlet.NotFoundServlet;
import lombok.Setter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ServletManager {

    private final Map<String, HttpServlet> servletMap = new HashMap<>();

    @Setter
    private HttpServlet defaultServlet = new DiscardServlet();
    @Setter
    private HttpServlet notFoundErrorServlet = new NotFoundServlet();
    @Setter
    private HttpServlet internalErrorServlet = new InternalErrorServlet();

    public void add(String path, HttpServlet servlet) {
        servletMap.put(path, servlet);
    }

    public void execute(HttpRequest request, HttpResponse response) throws IOException {
        System.out.println("request = " + request);
        try {
            HttpServlet servlet = servletMap.getOrDefault(request.getPath(), defaultServlet);
            System.out.println("servlet = " + servlet);
            if (servlet == null) {
                throw new PageNotFoundException("request url=" + request.getPath());
            }
            servlet.service(request, response);
            response.flush();

        } catch (PageNotFoundException e) {
            notFoundErrorServlet.service(request, response);
            response.flush();
        } catch (Exception e) {
            e.printStackTrace();
            internalErrorServlet.service(request, response);
            response.flush();
        }
    }
}
