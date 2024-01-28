package com.hoonjin.study.java.basic.construct;

public class MethodInitMain3 {

    public static void main(String[] args) {

        MemberInit memberInit1 = new MemberInit();
        memberInit1.initMember("이름1", 15, 90);

        MemberInit memberInit2 = new MemberInit();
        memberInit2.initMember("이름2", 16, 80);

        MemberInit[] members = {memberInit1, memberInit2};
    }

}
