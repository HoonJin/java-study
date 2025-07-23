package com.hoonjin.study.spring.splearn.application.member;

import com.hoonjin.study.spring.splearn.application.member.provided.MemberFinder;
import com.hoonjin.study.spring.splearn.application.member.required.MemberRepository;
import com.hoonjin.study.spring.splearn.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Transactional
@Validated
public class MemberQueryService implements MemberFinder {

    private final MemberRepository memberRepository;

    @Override
    public Member find(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow();
    }
}
