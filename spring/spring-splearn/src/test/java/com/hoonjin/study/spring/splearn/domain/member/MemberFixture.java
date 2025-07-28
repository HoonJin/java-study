package com.hoonjin.study.spring.splearn.domain.member;

import org.springframework.test.util.ReflectionTestUtils;

public class MemberFixture {

    public static MemberRegisterRequest createMemberRegisterRequest() {
        return createMemberRegisterRequest("toby@splearn.app");
    }

    public static MemberRegisterRequest createMemberRegisterRequest(String email) {
        return new MemberRegisterRequest(email, "Charlie", "verysecret");
    }

    public static PasswordEncoder createpasswordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(String password) {
                return password.toUpperCase();
            }

            @Override
            public boolean matches(String password, String PasswordHash) {
                return encode(password).equals(PasswordHash);
            }
        };
    }

    public static Member createMember() {
        return Member.register(createMemberRegisterRequest(), createpasswordEncoder());
    }

    public static Member createMember(Long id) {
        Member member = Member.register(createMemberRegisterRequest(), createpasswordEncoder());
        ReflectionTestUtils.setField(member, "id", id);
        return member;
    }

    public static Member createMember(String email) {
        return Member.register(createMemberRegisterRequest(email), createpasswordEncoder());
    }
}
