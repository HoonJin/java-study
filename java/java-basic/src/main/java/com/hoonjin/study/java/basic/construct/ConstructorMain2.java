package com.hoonjin.study.java.basic.construct;

public class ConstructorMain2 {

    public static void main(String[] args) {

        MemberConstruct member1 = new MemberConstruct("이름1", 15, 90);
        MemberConstruct member2 = new MemberConstruct("이름2", 16);

        MemberConstruct[] members = {member1, member2};

        for (MemberConstruct member : members) {
            System.out.println("이름: " + member.name + ", 나이: " + member.age + ", 성적: = " + member.grade);
        }
    }

}
