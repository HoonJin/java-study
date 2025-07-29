package com.hoonjin.study.spring.splearn.adapter;

import com.hoonjin.study.spring.splearn.domain.member.DuplicateEmailException;
import com.hoonjin.study.spring.splearn.domain.member.DuplicateProfileException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleException(Exception ex) {
        return getProblemDetail(HttpStatus.INTERNAL_SERVER_ERROR, ex);
    }

    @ExceptionHandler({DuplicateEmailException.class, DuplicateProfileException.class})
    public ProblemDetail handleDuplicateEmailException(DuplicateEmailException ex) {
        return getProblemDetail(HttpStatus.CONFLICT, ex);
    }

    private static ProblemDetail getProblemDetail(HttpStatus status, Exception ex) {
        // RFC9457
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(status, ex.getMessage());
        problemDetail.setProperty("exception", ex.getClass().getSimpleName());
        problemDetail.setProperty("timestamp", LocalDateTime.now());
        return problemDetail;
    }
}
