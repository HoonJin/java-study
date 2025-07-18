package com.hoonjin.study.spring.splearn.application.provided;

import com.hoonjin.study.spring.splearn.application.MemberService;
import com.hoonjin.study.spring.splearn.application.required.EmailSender;
import com.hoonjin.study.spring.splearn.application.required.MemberRepository;
import com.hoonjin.study.spring.splearn.domain.Email;
import com.hoonjin.study.spring.splearn.domain.Member;
import com.hoonjin.study.spring.splearn.domain.MemberFixture;
import com.hoonjin.study.spring.splearn.domain.MemberStatus;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

class MemberRegisterManualTest {

    @Test
    void registerTestStub() {
        MemberRegister register = new MemberService(
            new MemberRepositoryStub(), // MemberRepository
            new EmailSenderStub(), // EmailSender
            MemberFixture.createpasswordEncoder()
        );

        Member member = register.register(MemberFixture.createMemberRegisterRequest());

        assertThat(member.getId()).isNotNull();
        assertThat(member.getStatus()).isEqualTo(MemberStatus.PENDING);
    }

    @Test
    void registerTestMock() {
        EmailSenderMock emailSenderMock = new EmailSenderMock();
        MemberRegister register = new MemberService(
            new MemberRepositoryStub(), // MemberRepository
            emailSenderMock, // EmailSender
            MemberFixture.createpasswordEncoder()
        );

        Member member = register.register(MemberFixture.createMemberRegisterRequest());

        assertThat(member.getId()).isNotNull();
        assertThat(member.getStatus()).isEqualTo(MemberStatus.PENDING);

        assertThat(emailSenderMock.emails).hasSize(1);
        assertThat(emailSenderMock.emails.getFirst()).isEqualTo(member.getEmail());
    }

    @Test
    void registerTestMockito() {
        EmailSender emailSenderMock = Mockito.mock(EmailSender.class);
        MemberRegister register = new MemberService(
            new MemberRepositoryStub(), // MemberRepository
            emailSenderMock, // EmailSender
            MemberFixture.createpasswordEncoder()
        );

        Member member = register.register(MemberFixture.createMemberRegisterRequest());

        assertThat(member.getId()).isNotNull();
        assertThat(member.getStatus()).isEqualTo(MemberStatus.PENDING);

        Mockito.verify(emailSenderMock)
            .send(eq(member.getEmail()), any(), any());
    }


    static class MemberRepositoryStub implements MemberRepository {

        private Long id = 1L;

        @Override
        public Member save(Member member) {
            ReflectionTestUtils.setField(member, "id", id++);
            return member;
        }

        @Override
        public Optional<Member> findByEmail(Email email) {
            return Optional.empty();
        }
    }

    static class EmailSenderStub implements EmailSender {
        @Override
        public void send(Email email, String subject, String body) {

        }
    }

    static class EmailSenderMock implements EmailSender {
        List<Email> emails = new ArrayList<>();

        @Override
        public void send(Email email, String subject, String body) {
            emails.add(email);
        }
    }
}
