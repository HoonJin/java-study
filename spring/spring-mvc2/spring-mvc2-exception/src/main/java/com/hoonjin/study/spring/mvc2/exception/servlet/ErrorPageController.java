package com.hoonjin.study.spring.mvc2.exception.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class ErrorPageController {

    // from RequestDispatcher
    public static final String ERROR_EXCEPTION = "javax.servlet.error.exception";
    public static final String ERROR_EXCEPTION_TYPE = "javax.servlet.error.exception_type";
    public static final String ERROR_MESSAGE = "javax.servlet.error.message";
    public static final String ERROR_REQUEST_URI = "javax.servlet.error.request_uri";
    public static final String ERROR_SERVLET_NAME = "javax.servlet.error.servlet_name";
    public static final String ERROR_STATUS_CODE = "javax.servlet.error.status_code";


    @RequestMapping("/error-page/404")
    public String errorPage404(HttpServletRequest request, HttpServletResponse response) {
        printErrorInfo(request);
        return "error-page/404";
    }

    @RequestMapping("/error-page/500")
    public String errorPage500(HttpServletRequest request, HttpServletResponse response) {
        printErrorInfo(request);
        return "error-page/500";
    }

    @RequestMapping(value = "/error-page/500", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> errorApi500(HttpServletRequest request, HttpServletResponse response) {
        log.error("api error 500");

        Integer status = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        Map<String, Object> result = new HashMap<>();

        Exception ex = (Exception) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);

        result.put("status", status);
        result.put("message", ex.getMessage());

//        return new ResponseEntity<>(result, HttpStatus.valueOf(status));
        return ResponseEntity.internalServerError().body(result);
    }

    private void printErrorInfo(HttpServletRequest request) {
//        request.getAttributeNames().asIterator()
//                .forEachRemaining(name -> log.info("{} = {}", name, request.getAttribute(name)));

        log.info("REQUEST ERROR_EXCEPTION {}", request.getAttribute(ERROR_EXCEPTION));
        log.info("REQUEST ERROR_EXCEPTION_TYPE {}", request.getAttribute(ERROR_EXCEPTION_TYPE));
        log.info("REQUEST ERROR_MESSAGE {}", request.getAttribute(ERROR_MESSAGE));
        log.info("REQUEST ERROR_REQUEST_URI {}", request.getAttribute(ERROR_REQUEST_URI));
        log.info("REQUEST ERROR_SERVLET_NAME {}", request.getAttribute(ERROR_SERVLET_NAME));
        log.info("REQUEST ERROR_STATUS_CODE {}", request.getAttribute(ERROR_STATUS_CODE));
        log.error("DISPATCHER TYPE: {}", request.getDispatcherType());
        log.info("");
    }
}
