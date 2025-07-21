package com.hoonjin.study.spring.splearn.adapter.integration;

import com.hoonjin.study.spring.splearn.domain.Email;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.StdIo;
import org.junitpioneer.jupiter.StdOut;

import static org.assertj.core.api.Assertions.assertThat;

class DummyEmailSenderTest {

    @Test
    @StdIo
    void dummyEmailSender(StdOut out) {
        DummyEmailSender dummyEmailSender = new DummyEmailSender();
        dummyEmailSender.send(new Email("toby@splearn.app"), "Test Subject", "Test Body");

        assertThat(out.capturedLines()[0])
            .isEqualTo("DummyEmailSender.send() email = Email[address=toby@splearn.app]");
    }

}