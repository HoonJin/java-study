package com.hoonjin.study.spring.mvc2.login.domain.login;

import com.hoonjin.study.spring.mvc2.login.domain.member.Member;
import com.hoonjin.study.spring.mvc2.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(String loginId, String password) {
        return memberRepository.findByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }
}
