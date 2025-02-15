package com.hoonjin.study.spring.mvc2.exception;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

//@Component
public class WebServerCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        ErrorPage errorPage404 = new ErrorPage(NOT_FOUND, "/error-page/404");
        ErrorPage errorPage500 = new ErrorPage(INTERNAL_SERVER_ERROR, "/error-page/500");

        ErrorPage errorPageRuntimeEx = new ErrorPage(RuntimeException.class, "/error-page/500");

        factory.addErrorPages(
                errorPage404,
                errorPage500,
                errorPageRuntimeEx
        );
    }
}
