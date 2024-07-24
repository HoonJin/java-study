package com.hoonjin.study.spring.hello;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;

//@SpringBootApplication
public class SpringHelloApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringHelloApplication.class, args);

        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        WebServer webServer = serverFactory.getWebServer(
            servletContext -> {
                HelloController helloController = new HelloController();

                servletContext.addServlet("frontcontroller", new HttpServlet() {
                    @Override
                    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
                        // 인증, 보안, 다국어 등 공통 기능

                        if (req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())) {
                            String name = req.getParameter("name");
                            String body = helloController.hello(name);

                            resp.setStatus(HttpStatus.OK.value());
                            resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
                            resp.getWriter().write(body);
                        }
                        else if (req.getRequestURI().equals("/bye")) {
                            //
                        } else {
                            resp.setStatus(HttpStatus.NOT_FOUND.value());
                        }
                    }
                }).addMapping("/*");
            }
        );
        webServer.start();
    }
}
