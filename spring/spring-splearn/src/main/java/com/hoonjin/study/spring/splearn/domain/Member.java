package com.hoonjin.study.spring.splearn.domain;

import lombok.Getter;
import lombok.ToString;
import org.springframework.util.Assert;

import java.util.Objects;

@Getter
@ToString
public class Member {

    private String email;

    private String nickname;

    private String passwordHash;

    private MemberStatus status;

    public Member(String email, String nickname, String passwordHash) {
        this.email = Objects.requireNonNull(email);
        this.nickname = Objects.requireNonNull(nickname);
        this.passwordHash = Objects.requireNonNull(passwordHash);
        this.status = MemberStatus.PENDING;
    }

    public void activate() {
//        if (status != MemberStatus.PENDING) {
//            throw new IllegalStateException("Member is already activated or deactivated");
//        }
        // 장황한 if 문 대신 Assert 사용
        Assert.state(status == MemberStatus.PENDING, "PENDING 상태의 회원만 활성화할 수 있습니다");

        status = MemberStatus.ACTIVE;
    }

    public void deactivate() {
        Assert.state(status == MemberStatus.ACTIVE, "ACTIVE 상태가 아닙니다");

        status = MemberStatus.DEACTIVATED;
    }
}
