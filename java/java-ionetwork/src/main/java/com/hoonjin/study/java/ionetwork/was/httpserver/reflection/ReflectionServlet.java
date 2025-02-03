package com.hoonjin.study.java.ionetwork.was.httpserver.reflection;

import com.hoonjin.study.java.ionetwork.was.httpserver.HttpRequest;
import com.hoonjin.study.java.ionetwork.was.httpserver.HttpResponse;
import com.hoonjin.study.java.ionetwork.was.httpserver.HttpServlet;
import com.hoonjin.study.java.ionetwork.was.httpserver.PageNotFoundException;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@RequiredArgsConstructor
public class ReflectionServlet implements HttpServlet {

    private final List<Object> controllers;

    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        String path = request.getPath();

        for (Object controller : controllers) {
            Class<?> aClass = controller.getClass();
            Method[] declaredMethods = aClass.getDeclaredMethods();
            for (Method method : declaredMethods) {
                if (path.equals("/" + method.getName())) {
                    invoke(request, response, controller, method);
                    return;
                }
            }
        }

        throw new PageNotFoundException("request = " + path);
    }

    private static void invoke(HttpRequest request, HttpResponse response, Object controller, Method method) {
        try {
            method.invoke(controller, request, response);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
