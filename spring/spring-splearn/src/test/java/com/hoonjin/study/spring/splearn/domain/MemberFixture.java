package com.hoonjin.study.spring.splearn.domain;

public class MemberFixture {

    public static MemberRegisterRequest createMemberRegisterRequest() {
        return createMemberRegisterRequest("toby@splearn.app");
    }

    public static MemberRegisterRequest createMemberRegisterRequest(String email) {
        return new MemberRegisterRequest(email, "Toby", "secret");
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
}
