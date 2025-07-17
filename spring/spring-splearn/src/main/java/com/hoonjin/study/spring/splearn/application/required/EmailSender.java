package com.hoonjin.study.spring.splearn.application.required;

import com.hoonjin.study.spring.splearn.domain.Email;

// 이메일 발송 관련 기능 제공
public interface EmailSender {

    void send(Email email, String subject, String body);
}
