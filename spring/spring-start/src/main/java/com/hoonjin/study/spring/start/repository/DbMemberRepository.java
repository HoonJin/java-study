package com.hoonjin.study.spring.start.repository;

import com.hoonjin.study.spring.start.domain.Member;

import java.util.List;
import java.util.Optional;

public class DbMemberRepository implements MemberRepository {
    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
