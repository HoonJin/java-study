package com.hoonjin.study.java.was.httpserver.annotation;

import com.hoonjin.study.java.was.httpserver.HttpRequest;
import com.hoonjin.study.java.was.httpserver.HttpResponse;
import com.hoonjin.study.java.was.httpserver.HttpServlet;
import com.hoonjin.study.java.was.httpserver.PageNotFoundException;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@RequiredArgsConstructor
public class AnnotationServletV2 implements HttpServlet {

    private final List<Object> controllers;

    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        String path = request.getPath();

        for (Object controller : controllers) {
            Method[] methods = controller.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Mapping.class)) {
                    Mapping mapping = method.getAnnotation(Mapping.class);
                    if (mapping.value().equals(path)) {
                        invoke(controller, method, request, response);
                        return;
                    }
                }
            }
        }
        throw new PageNotFoundException("request=" + path);
    }

    private static void invoke(Object controller, Method method, HttpRequest request, HttpResponse response) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        Object[] args = new Object[parameterTypes.length];

        for (int i = 0; i < args.length; i++) {
            if (parameterTypes[i] == HttpRequest.class) {
                args[i] = request;
            } else if (parameterTypes[i] == HttpResponse.class) {
                args[i] = response;
            } else {
                throw new IllegalArgumentException("unsupported parameter type: " + parameterTypes[i]);
            }
        }

        try {
            method.invoke(controller, args);
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
