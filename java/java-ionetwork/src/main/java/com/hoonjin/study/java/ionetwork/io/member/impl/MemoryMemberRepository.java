package com.hoonjin.study.java.ionetwork.io.member.impl;

import com.hoonjin.study.java.ionetwork.io.member.Member;
import com.hoonjin.study.java.ionetwork.io.member.MemberRepository;

import java.util.ArrayList;
import java.util.List;

public class MemoryMemberRepository implements MemberRepository {

    private final List<Member> members = new ArrayList<>();

    @Override
    public void add(Member member) {
        members.add(member);
    }

    @Override
    public List<Member> findAll() {
        return members;
    }
}
