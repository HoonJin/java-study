package com.hoonjin.study.spring.mvc2.fileupload.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.Collection;

@Slf4j
@Controller
public class ServletUploadControllerV1 {

    @GetMapping("/servlet/v1/upload")
    public String newFile() {
        return "upload-form";
    }

    @PostMapping("/servlet/v1/upload")
    public String saveFileV1(HttpServletRequest request) throws ServletException, IOException {
        log.info("req = {}", request);

        String itemName = request.getParameter("itemName");
        log.info("itemName={}", itemName);

        Collection<Part> parts = request.getParts();
        log.info("parts = {}", parts);

        return "upload-form";
    }
}
