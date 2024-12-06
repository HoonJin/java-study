package com.hoonjin.study.spring.mvc2.exception.resolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hoonjin.study.spring.mvc2.exception.exception.UserException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;

@Slf4j
public class HandlerUserExceptionResolver implements HandlerExceptionResolver {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try {
            if (ex instanceof UserException) {
                String accept = request.getHeader("accept");
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

                if ("application/json".equals(accept)) {
                    HashMap<String, Object> errorResult = new HashMap<>();
                    errorResult.put("ex", ex.getClass());
                    errorResult.put("message", ex.getMessage());

                    String errorResponse = objectMapper.writeValueAsString(errorResult);

                    response.setContentType("application/json");
                    response.setCharacterEncoding("utf-8");
                    response.getWriter().write(errorResponse);
                    return new ModelAndView(); // 이부분에 유념할 것
                } else {
                    return new ModelAndView("error/500");
                }
            }
            return null;
        } catch (IOException e) {
            log.error("resolver ioexception: ", e);
            return new ModelAndView("error/500");
        }
    }
}
