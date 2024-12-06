package com.hoonjin.study.spring.mvc2.fileupload.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
public class SpringUploadController {

    @Value("${file.dir}")
    private String fileDir;

    @GetMapping("/spring/upload")
    public String newFile() {
        return "upload-form";
    }

    @PostMapping("/spring/upload")
    public String saveFile(@RequestParam String itemName,
                           @RequestParam MultipartFile file,
                           HttpServletRequest request
    ) throws IOException {
        log.info("req = {}", request);
        log.info("itemName={}", itemName);

        if (!file.isEmpty()) {
            String filePath = fileDir + file.getOriginalFilename();
            file.transferTo(new File(filePath));
        }
        return "upload-form";
    }
}
