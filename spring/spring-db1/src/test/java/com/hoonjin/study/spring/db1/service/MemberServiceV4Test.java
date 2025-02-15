package com.hoonjin.study.spring.db1.service;

import com.hoonjin.study.spring.db1.domain.Member;
import com.hoonjin.study.spring.db1.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class MemberServiceV4Test {

    public static final String MemberA = "memberA";
    public static final String MemberB = "memberB";
    public static final String MemberEX = "ex";

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberServiceV4 memberService;

    @AfterEach
    void after() {
        // 좀 구리지만 하나씩 다 지워준다.
        memberRepository.delete(MemberA);
        memberRepository.delete(MemberB);
        memberRepository.delete(MemberEX);
    }

    @Test
    void accountTransfer() {
        // given
        Member memberA = new Member(MemberA, 10000);
        Member memberB = new Member(MemberB, 10000);
        memberRepository.save(memberA);
        memberRepository.save(memberB);

        // when
        memberService.accountTransfer(memberA.getMemberId(), memberB.getMemberId(), 2000);

        // then
        Member byIdA = memberRepository.findById(memberA.getMemberId());
        Member byIdB = memberRepository.findById(memberB.getMemberId());

        Assertions.assertThat(byIdA.getMoney()).isEqualTo(8000);
        Assertions.assertThat(byIdB.getMoney()).isEqualTo(12000);
    }

    @Test
    void aopCheck() {
        log.info("memberRepository = {}", memberRepository.getClass());
        log.info("memberService = {}", memberService.getClass());

        Assertions.assertThat(AopUtils.isAopProxy(memberRepository)).isTrue();
        Assertions.assertThat(AopUtils.isAopProxy(memberService)).isTrue();
    }

    @Test
    void accountTransferEX() {
        // given
        Member memberA = new Member(MemberA, 10000);
        Member memberEX = new Member(MemberEX, 10000);
        memberRepository.save(memberA);
        memberRepository.save(memberEX);

        // when
        Assertions.assertThatThrownBy(() -> memberService.accountTransfer(memberA.getMemberId(), memberEX.getMemberId(), 2000))
                .isInstanceOf(IllegalStateException.class);

        // then
        Member byIdA = memberRepository.findById(memberA.getMemberId());
        Member byIdB = memberRepository.findById(memberEX.getMemberId());

        Assertions.assertThat(byIdA.getMoney()).isEqualTo(10000);
        Assertions.assertThat(byIdB.getMoney()).isEqualTo(10000);
    }
}