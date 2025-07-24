package com.hoonjin.study.spring.splearn.application.member;

import com.hoonjin.study.spring.splearn.application.member.provided.MemberFinder;
import com.hoonjin.study.spring.splearn.application.member.provided.MemberRegister;
import com.hoonjin.study.spring.splearn.application.member.required.EmailSender;
import com.hoonjin.study.spring.splearn.application.member.required.MemberRepository;
import com.hoonjin.study.spring.splearn.domain.member.*;
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

    @Override
    public Member deactivate(Long memberId) {
        Member member = memberFinder.find(memberId);

        member.deactivate();

        return memberRepository.save(member);
    }

    @Override
    public Member updateInfo(Long memberId, MemberInfoUpdateRequest updateRequest) {
        Member member = memberFinder.find(memberId);

        checkDuplicateProfile(member, updateRequest.profileAddress());

        member.updateInfo(updateRequest);

        return memberRepository.save(member);
    }

    private void checkDuplicateProfile(Member member, String profileAddress) {
        if (profileAddress.isEmpty()) return;
        Profile profile = member.getDetail().getProfile();
        if (profile != null && profile.address().equals(profileAddress)) return;

        memberRepository.findByProfile(new Profile(profileAddress)).ifPresent(existingMember -> {
            throw new DuplicateProfileException("이미 등록된 프로필 주소입니다.");
        });
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
