package com.hoonjin.study.spring.rest1.controller;

import com.hoonjin.study.spring.rest1.bean.HelloWorldBean;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;

@RestController
@RequiredArgsConstructor
public class HelloWorldController {

    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;

//    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("hello world");
    }

    @GetMapping("/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name) {
        String message = String.format("hello world, %s", name);
        return new HelloWorldBean(message);
    }

    @GetMapping("/greeting")
    public String message() {
        System.out.println("LocaleContextHolder.getLocale() = " + LocaleContextHolder.getLocale());
        return messageSource.getMessage("greeting.message", null, LocaleContextHolder.getLocale());
    }

    @GetMapping("/greeting1")
    public String message1() {
        return messageSource.getMessage("greeting.message", null, null);
    }

    @GetMapping("/greeting/jp")
    public String messageJp() {
        return messageSource.getMessage("greeting.message", null, Locale.JAPAN);
    }
}
