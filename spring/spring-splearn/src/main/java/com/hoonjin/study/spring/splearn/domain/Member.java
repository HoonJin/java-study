package com.hoonjin.study.spring.splearn.domain;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;
import org.springframework.util.Assert;

import static java.util.Objects.requireNonNull;

@Entity
@Getter
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@NaturalIdCache
public class Member extends AbstractEntity {

    @NaturalId
    private Email email;

    private String nickname;

    private String passwordHash;

    private MemberStatus status;

    public static Member register(MemberRegisterRequest request, PasswordEncoder passwordEncoder) {
        Member member = new Member();

        member.email = new Email(requireNonNull(request.email()));
        member.nickname = requireNonNull(request.nickname());
        member.passwordHash = passwordEncoder.encode(requireNonNull(request.password()));

        member.status = MemberStatus.PENDING;

        return member;
    }

    public void activate() {
//        if (status != MemberStatus.PENDING) {
//            throw new IllegalStateException("Member is already activated or deactivated");
//        }// 장황한 if 문 대신 Assert 사용
        Assert.state(status == MemberStatus.PENDING, "PENDING 상태의 회원만 활성화할 수 있습니다");

        status = MemberStatus.ACTIVE;
    }

    public void deactivate() {
        Assert.state(status == MemberStatus.ACTIVE, "ACTIVE 상태가 아닙니다");

        status = MemberStatus.DEACTIVATED;
    }

    public boolean verifyPassword(String secret, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(secret, passwordHash);
    }

    public void changeNickname(String nickname) {
        this.nickname = requireNonNull(nickname);
    }

    public void changePassword(String password, PasswordEncoder passwordEncoder) {
        this.passwordHash = passwordEncoder.encode(requireNonNull(password));
    }

    public boolean isActive() {
        return status == MemberStatus.ACTIVE;
    }
}
