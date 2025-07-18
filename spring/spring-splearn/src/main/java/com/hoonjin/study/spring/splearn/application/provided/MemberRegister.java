package com.hoonjin.study.spring.splearn.application.provided;

import com.hoonjin.study.spring.splearn.domain.Member;
import com.hoonjin.study.spring.splearn.domain.MemberRegisterRequest;

// 회원 등록 관련 기능 제공
public interface MemberRegister {

    Member register(MemberRegisterRequest registerRequest);

}
