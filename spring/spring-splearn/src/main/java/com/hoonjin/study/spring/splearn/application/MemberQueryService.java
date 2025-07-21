package com.hoonjin.study.spring.splearn.application;

import com.hoonjin.study.spring.splearn.application.provided.MemberFinder;
import com.hoonjin.study.spring.splearn.application.required.MemberRepository;
import com.hoonjin.study.spring.splearn.domain.Member;
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
