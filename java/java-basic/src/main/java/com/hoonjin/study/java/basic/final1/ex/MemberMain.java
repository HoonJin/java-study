package com.hoonjin.study.java.basic.final1.ex;

public class MemberMain {

    public static void main(String[] args) {
        Member member = new Member("1", "Test");
        member.print();
        //member.changeData("asdf", "Test2");
        member.changeData("Changed Name");
        member.print();
    }
}
