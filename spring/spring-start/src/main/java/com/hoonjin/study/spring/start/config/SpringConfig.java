package com.hoonjin.study.spring.start.config;

import com.hoonjin.study.spring.start.domain.Member;
import com.hoonjin.study.spring.start.repository.*;
import com.hoonjin.study.spring.start.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Configuration
public class SpringConfig {

//    @Bean
//    public MemberRepository memberRepository() {
//        return new DbMemberRepository();
//    }

//    @Bean
//    public MemberRepository memberRepository(DataSource dataSource) {
////        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//    }

//    @Bean
//    public MemberRepository memberRepository(EntityManager entityManager) {
//        return new JpaMemberRepository(entityManager);
//    }

//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository());
//    }

    @Bean
    public MemberService memberService(MemberRepository memberRepository) {
        return new MemberService(memberRepository);
    }
}
