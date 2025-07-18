package com.hoonjin.study.spring.splearn.application;

import com.hoonjin.study.spring.splearn.application.provided.MemberRegister;
import com.hoonjin.study.spring.splearn.application.required.EmailSender;
import com.hoonjin.study.spring.splearn.application.required.MemberRepository;
import com.hoonjin.study.spring.splearn.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService implements MemberRegister {

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

    private void checkDuplicateEmail(MemberRegisterRequest registerRequest) {
        memberRepository.findByEmail(new Email(registerRequest.email())).ifPresent(member -> {
            throw new DuplicateEmailException("이미 등록된 이메일입니다.");
        });
    }

    private void sendWelcomeEmail(Member member) {
        emailSender.send(member.getEmail(), "등록을 완료해주세요", "아래 링크를 클릭해서 등록을 완료해 주세요.");
    }
}
