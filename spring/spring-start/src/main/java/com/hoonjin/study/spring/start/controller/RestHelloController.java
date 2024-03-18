package com.hoonjin.study.spring.start.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestHelloController {

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @GetMapping("/hello-api")
    public Hello helloApi(@RequestParam String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
}
