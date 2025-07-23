package com.hoonjin.study.spring.splearn.application.member.provided;

import com.hoonjin.study.spring.splearn.domain.member.Member;
import com.hoonjin.study.spring.splearn.domain.member.MemberRegisterRequest;
import jakarta.validation.Valid;

// 회원 등록 관련 기능 제공
public interface MemberRegister {

    Member register(@Valid MemberRegisterRequest registerRequest);

    Member activate(Long memberId);
}
