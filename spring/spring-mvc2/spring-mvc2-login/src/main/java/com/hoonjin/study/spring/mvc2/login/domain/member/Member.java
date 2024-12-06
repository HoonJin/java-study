package com.hoonjin.study.spring.mvc2.login.domain.member;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Member {

    private Long id;

    @NotEmpty
    private String loginId; // id

    @NotEmpty
    private String name;

    @NotEmpty
    private String password;;

}
