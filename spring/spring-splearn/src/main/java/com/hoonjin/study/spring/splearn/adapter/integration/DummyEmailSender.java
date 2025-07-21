package com.hoonjin.study.spring.splearn.adapter.integration;

import com.hoonjin.study.spring.splearn.application.required.EmailSender;
import com.hoonjin.study.spring.splearn.domain.Email;
import org.springframework.context.annotation.Fallback;
import org.springframework.stereotype.Component;

@Component
@Fallback
public class DummyEmailSender implements EmailSender {

    @Override
    public void send(Email email, String subject, String body) {
        System.out.println("DummyEmailSender.send() email = " + email);
    }
}
