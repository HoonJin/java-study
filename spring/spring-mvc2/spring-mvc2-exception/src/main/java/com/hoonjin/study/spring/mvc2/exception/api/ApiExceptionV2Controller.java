package com.hoonjin.study.spring.mvc2.exception.api;

import com.hoonjin.study.spring.mvc2.exception.exception.UserException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiExceptionV2Controller {

    record MemberDto(String memberId, String name) {};

    @GetMapping("/api2/members/{id}")
    public MemberDto getMember(@PathVariable("id") String id) {
        if (id.equals("ex"))
            throw new RuntimeException("ex");

        if (id.equals("bad"))
            throw new IllegalArgumentException("wrong argument");

        if (id.equals("user-ex"))
            throw new UserException("사용자 오류");

        return new MemberDto(id, "hello" + id);
    }

}
