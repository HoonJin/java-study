package com.hoonjin.study.spring.apptest.study;

import com.hoonjin.study.spring.apptest.domain.Member;
import com.hoonjin.study.spring.apptest.domain.Study;
import com.hoonjin.study.spring.apptest.member.MemberService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StudyService {

    private final MemberService memberService;
    private final StudyRepository studyRepository;

    public Study createStudy(Long memberId, Study study) {
        Member member = memberService.findById(memberId);
        if (member == null)
            throw new IllegalArgumentException("member id is wrong");

        study.setOwner(member);
        return studyRepository.save(study);
    }
}
