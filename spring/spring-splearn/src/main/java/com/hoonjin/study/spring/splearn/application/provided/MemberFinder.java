package com.hoonjin.study.spring.splearn.application.provided;

import com.hoonjin.study.spring.splearn.domain.Member;

public interface MemberFinder {

    Member find(Long memberId);
}
