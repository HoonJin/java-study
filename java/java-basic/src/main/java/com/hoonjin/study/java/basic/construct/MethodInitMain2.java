package com.hoonjin.study.java.basic.construct;

import com.hoonjin.study.java.basic.ref.Student;

public class MethodInitMain2 {

    public static void main(String[] args) {

        MemberInit memberInit1 = new MemberInit();
        initMember(memberInit1, "이름1", 15, 90);

        MemberInit memberInit2 = new MemberInit();
        initMember(memberInit2, "이름2", 16, 80);

        MemberInit[] members = {memberInit1, memberInit2};
    }

    static void initMember(MemberInit memberInit, String name, int age, int grade) {
        memberInit.name = name;
        memberInit.age = age;
        memberInit.grade = grade;
    }
}
