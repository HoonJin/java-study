package com.hoonjin.study.spring.splearn.application.member.provided;

import com.hoonjin.study.spring.splearn.domain.member.Member;

public interface MemberFinder {

    Member find(Long memberId);
}
