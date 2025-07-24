package com.hoonjin.study.spring.splearn.domain.member;

import org.springframework.util.Assert;

import java.util.regex.Pattern;

public record Profile(
    String address
) {

    private static final Pattern PROFILE_ADDRESS_PATTERN = Pattern.compile("^[a-zA-Z0-9]{2,15}$");

    public Profile {
        Assert.isTrue(address != null," 프로필 주소는 null이 될 수 없습니다.");
        Assert.isTrue(address.isEmpty() || PROFILE_ADDRESS_PATTERN.matcher(address).matches(), "유효하지 않은 프로필 주소 형식입니다: " + address);
    }

    public String url() {
        return "@" + address;
    }
}
