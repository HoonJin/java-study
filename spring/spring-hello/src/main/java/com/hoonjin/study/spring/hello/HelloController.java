package com.hoonjin.study.spring.hello;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements ApplicationContextAware {

    private final HelloService helloService;
    private ApplicationContext applicationContext;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello(String name) {
        if (!StringUtils.hasText(name)) {
            throw new IllegalArgumentException();
        }
        return helloService.sayHello(name);
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("applicationContext = " + applicationContext);
        this.applicationContext = applicationContext;
    }

    @GetMapping("/count")
    public String count(String name) {
        return name + ": " + helloService.countOf(name);
    }
}
