package com.hoonjin.study.spring.btcores.autoconfig.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;


    @Transactional
    @Test
    void memberTest() {
        Member newMember = new Member("A", "memberA");
        memberRepository.initTable();

        memberRepository.save(newMember);

        Member member = memberRepository.find("A");
        System.out.println("member1 = " + member);

        Assertions.assertThat(newMember.getMemberId()).isEqualTo(member.getMemberId());
        Assertions.assertThat(newMember.getName()).isEqualTo(member.getName());
    }
}
