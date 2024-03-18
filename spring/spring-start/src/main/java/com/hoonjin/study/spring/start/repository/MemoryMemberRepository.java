package com.hoonjin.study.spring.start.repository;

import com.hoonjin.study.spring.start.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(it -> it.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return store.values().stream().toList();
    }

    public void clearStore() {
        store.clear();
    }
}
