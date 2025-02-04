package com.hoonjin.study.java.annotation.mapping;

import java.lang.reflect.Method;

public class TestControllerMain {

    public static void main(String[] args) {
        TestController controller = new TestController();

        Class<? extends TestController> aClass = controller.getClass();
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            SimpleMapping annotation = method.getAnnotation(SimpleMapping.class);
            if (annotation != null) {
                System.out.println("[" + annotation.value() + "] -> " + method);
            }
        }
    }
}
