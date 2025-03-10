package com.hoonjin.study.spring.mvc2.exception.api;

import com.hoonjin.study.spring.mvc2.exception.exception.BadRequestException;
import com.hoonjin.study.spring.mvc2.exception.exception.UserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
public class ApiExceptionController {

    record MemberDto(String memberId, String name) {}

    @GetMapping("/api/members/{id}")
    public MemberDto getMember(@PathVariable("id") String id) {
        if (id.equals("ex"))
            throw new RuntimeException("ex");

        if (id.equals("bad"))
            throw new IllegalArgumentException("wrong argument");

        if (id.equals("user-ex"))
            throw new UserException("사용자 오류");

        return new MemberDto(id, "hello" + id);
    }

    @GetMapping("/api/response-status-ex1")
    public String exception1() {
        throw new BadRequestException();
    }

    @GetMapping("/api/response-status-ex2")
    public String exception2() {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "error.bad", new IllegalArgumentException());
    }

    @GetMapping("/api/default-handler-ex")
    public String defaultException(@RequestParam Integer data) {
        return "ok";
    }
}
