package com.hoonjin.study.spring.splearn;

import com.hoonjin.study.spring.splearn.application.member.required.EmailSender;
import com.hoonjin.study.spring.splearn.domain.member.MemberFixture;
import com.hoonjin.study.spring.splearn.domain.member.PasswordEncoder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class SplearnTestConfiguration {

    @Bean
    public EmailSender emailSender() {
        return (email, subject, body) -> {
            System.out.println("email = " + email);
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return MemberFixture.createpasswordEncoder();
    }
}