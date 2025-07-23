package com.hoonjin.study.spring.splearn.application.member.required;

import com.hoonjin.study.spring.splearn.domain.shared.Email;

// 이메일 발송 관련 기능 제공
public interface EmailSender {

    void send(Email email, String subject, String body);
}
