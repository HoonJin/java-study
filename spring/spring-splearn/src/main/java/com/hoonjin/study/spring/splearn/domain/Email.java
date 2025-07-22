package com.hoonjin.study.spring.splearn.domain;

import org.springframework.util.Assert;

import java.util.regex.Pattern;

public record Email(
    String address
) {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    public Email {
        Assert.isTrue(EMAIL_PATTERN.matcher(address).matches(), "유효하지 않은 이메일 주소입니다: " + address);
    }
}
