package com.hoonjin.study.spring.splearn.domain;

public record MemberCreateRequest(
    String email,
    String nickname,
    String password
) {
}
