package com.hoonjin.study.spring.db1.repository;

import com.hoonjin.study.spring.db1.domain.Member;

public interface MemberRepository {

    Member save(Member member);

    Member findById(String memberId);

    int update(String memberId, int money);

    int delete(String memberId);

}
