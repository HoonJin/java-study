package com.hoonjin.study.spring.splearn.domain;

public record MemberRegisterRequest(
    String email,
    String nickname,
    String password
) {
}
