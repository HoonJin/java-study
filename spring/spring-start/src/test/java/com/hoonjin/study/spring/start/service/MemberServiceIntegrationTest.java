package com.hoonjin.study.spring.start.service;

import com.hoonjin.study.spring.start.domain.Member;
import com.hoonjin.study.spring.start.repository.MemberRepository;
import com.hoonjin.study.spring.start.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class MemberServiceIntegrationTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("hello");

        // when
        Long id = memberService.join(member);

        // then
        Member findMember = memberService.findOne(id).get();
        Assertions.assertThat(id).isEqualTo(findMember.getId());
    }

    @Test
    void duplicatedException() {
        // given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);

        // then
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}
