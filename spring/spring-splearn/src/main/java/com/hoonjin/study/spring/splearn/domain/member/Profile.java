package com.hoonjin.study.spring.splearn.domain.member;

import jakarta.persistence.Embeddable;
import org.springframework.util.Assert;

import java.util.regex.Pattern;

@Embeddable
public record Profile(
    String address
) {

    private static final Pattern PROFILE_ADDRESS_PATTERN = Pattern.compile("^[a-zA-Z0-9]{2,15}$");

    public Profile {
        Assert.isTrue(PROFILE_ADDRESS_PATTERN.matcher(address).matches(), "유효하지 않은 프로필 주소 형식입니다: " + address);
    }

    public String url() {
        return "@" + address;
    }
}
