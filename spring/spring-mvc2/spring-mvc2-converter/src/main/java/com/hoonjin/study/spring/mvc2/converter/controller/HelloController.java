package com.hoonjin.study.spring.mvc2.converter.controller;

import com.hoonjin.study.spring.mvc2.converter.type.IpPort;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request) {
        String data = request.getParameter("data");

        Integer intData = Integer.valueOf(data);
        System.out.println("intData = " + intData);
        return "ok";
    }

    @GetMapping("/hello-v2")
    public String helloV1(@RequestParam Integer data) {
        System.out.println("data = " + data);
        return "ok";
    }

    @GetMapping("ip-port")
    public String ipPort(@RequestParam IpPort ipPort) {
        System.out.println("ipPort = " + ipPort);
        return "ok";
    }
}
