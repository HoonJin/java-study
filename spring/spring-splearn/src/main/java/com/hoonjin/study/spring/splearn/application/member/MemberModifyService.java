package com.hoonjin.study.spring.splearn.application.member;

import com.hoonjin.study.spring.splearn.application.member.provided.MemberFinder;
import com.hoonjin.study.spring.splearn.application.member.provided.MemberRegister;
import com.hoonjin.study.spring.splearn.application.member.required.EmailSender;
import com.hoonjin.study.spring.splearn.application.member.required.MemberRepository;
import com.hoonjin.study.spring.splearn.domain.member.Member;
import com.hoonjin.study.spring.splearn.domain.member.MemberRegisterRequest;
import com.hoonjin.study.spring.splearn.domain.member.PasswordEncoder;
import com.hoonjin.study.spring.splearn.domain.member.DuplicateEmailException;
import com.hoonjin.study.spring.splearn.domain.shared.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Transactional
@Validated
public class MemberModifyService implements MemberRegister {

    private final MemberFinder memberFinder;
    private final MemberRepository memberRepository;
    private final EmailSender emailSender;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Member register(MemberRegisterRequest registerRequest) {
        checkDuplicateEmail(registerRequest);

        Member member = Member.register(registerRequest, passwordEncoder);
        memberRepository.save(member);

        sendWelcomeEmail(member);

        return member;
    }

    @Override
    public Member activate(Long memberId) {
        Member member = memberFinder.find(memberId);

        member.activate();

        return memberRepository.save(member);
    }

    private void checkDuplicateEmail(MemberRegisterRequest registerRequest) {
        memberRepository.findByEmail(new Email(registerRequest.email())).ifPresent(member -> {
            throw new DuplicateEmailException("이미 등록된 이메일입니다.");
        });
    }

    private void sendWelcomeEmail(Member member) {
        emailSender.send(member.getEmail(), "등록을 완료해주세요", "아래 링크를 클릭해서 등록을 완료해 주세요.");
    }

}
