package com.hoonjin.study.spring.start.config;

import com.hoonjin.study.spring.start.repository.DbMemberRepository;
import com.hoonjin.study.spring.start.repository.MemberRepository;
import com.hoonjin.study.spring.start.repository.MemoryMemberRepository;
import com.hoonjin.study.spring.start.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new DbMemberRepository();
    }

//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository());
//    }

    @Bean
    public MemberService memberService(MemberRepository memberRepository) {
        return new MemberService(memberRepository);
    }
}
