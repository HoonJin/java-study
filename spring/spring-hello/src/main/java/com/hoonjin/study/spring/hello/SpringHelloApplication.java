package com.hoonjin.study.spring.hello;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@ComponentScan
public class SpringHelloApplication {

    public static void main(String[] args) {

        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh();

                ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
                WebServer webServer = serverFactory.getWebServer(servletContext ->
                    servletContext.addServlet("dispatcherServlet", new DispatcherServlet(this))
                        .addMapping("/*")
                );
                webServer.start();
            }
        };

        ac.register(SpringHelloApplication.class);
        ac.refresh();
    }
}