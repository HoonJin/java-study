package com.hoonjin.study.spring.apptest.member;

import com.hoonjin.study.spring.apptest.domain.Member;

public interface MemberService {

    Member findById(Long memberId);
}
