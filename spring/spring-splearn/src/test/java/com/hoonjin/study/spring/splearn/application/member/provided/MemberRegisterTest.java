package com.hoonjin.study.spring.splearn.application.member.provided;

import com.hoonjin.study.spring.splearn.SplearnTestConfiguration;
import com.hoonjin.study.spring.splearn.domain.member.*;
import jakarta.persistence.EntityManager;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@Transactional
@Import(SplearnTestConfiguration.class)
//@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
record MemberRegisterTest(
    MemberRegister memberRegister,
    EntityManager entityManager
) {

    @Test
    void register() {
        Member member = memberRegister.register(MemberFixture.createMemberRegisterRequest());

        assertThat(member.getId()).isNotNull();
        assertThat(member.getStatus()).isEqualTo(MemberStatus.PENDING);
    }

    @Test
    void duplicateEmailFail() {
        memberRegister.register(MemberFixture.createMemberRegisterRequest());

        assertThatThrownBy(() -> memberRegister.register(MemberFixture.createMemberRegisterRequest()))
            .isInstanceOf(DuplicateEmailException.class);
    }

    @Test
    void memberRegisterRequestFail() {
        var invalid = new MemberRegisterRequest("toby@splearn.app", "Toby", "secret");
        runRegisterFailCase(invalid);

        var invalid2 = new MemberRegisterRequest("toby@splearn.app", "Toby______________________________________", "secret");
        runRegisterFailCase(invalid2);
    }

    private void runRegisterFailCase(MemberRegisterRequest invalid) {
        assertThatThrownBy(() -> memberRegister.register(invalid))
            .isInstanceOf(ConstraintViolationException.class);
    }

    @Test
    void activate() {
        Member member = registerMember();

        member = memberRegister.activate(member.getId());

        entityManager.flush();

        assertThat(member.getStatus()).isEqualTo(MemberStatus.ACTIVE);
        assertThat(member.getDetail().getActivatedAt()).isNotNull();
    }

    @Test
    void deactivate() {
        Member member = registerMember();

        memberRegister.activate(member.getId());
        entityManager.flush();
        entityManager.clear();

        member = memberRegister.deactivate(member.getId());

        assertThat(member.getStatus()).isEqualTo(MemberStatus.DEACTIVATED);
        assertThat(member.getDetail().getDeactivatedAt()).isNotNull();
    }

    @Test
    void updateInfo() {
        Member member = registerMember();

        memberRegister.activate(member.getId());
        entityManager.flush();
        entityManager.clear();

        var updateRequest = new MemberInfoUpdateRequest("Peter", "toby100", "자기소개");
        member = memberRegister.updateInfo(member.getId(), updateRequest);

        entityManager.flush();

        assertThat(member.getNickname()).isEqualTo(updateRequest.nickname());
        assertThat(member.getDetail().getProfile().address()).isEqualTo(updateRequest.profileAddress());

    }

    @Test
    void updateInfoFail() {
        Member member = registerMember();

        memberRegister.activate(member.getId());
        entityManager.flush();
        entityManager.clear();
        var updateRequest = new MemberInfoUpdateRequest("Peter", "toby100", "자기소개");
        memberRegister.updateInfo(member.getId(), updateRequest);

        Member member2 = registerMember("toby2@splearn.app");
        memberRegister.activate(member2.getId());
        entityManager.flush();
        entityManager.clear();

        assertThatThrownBy(() -> memberRegister.updateInfo(member2.getId(), updateRequest))
            .isInstanceOf(DuplicateProfileException.class);

        // 다른 프로필 주소로는 변경 가능
        memberRegister.updateInfo(member2.getId(), new MemberInfoUpdateRequest("James", "toby101", "Introduction"));

        // 기존 프로필 주소를 바꾸는 것도 가능
        memberRegister.updateInfo(member.getId(), new MemberInfoUpdateRequest("James", "toby100", "Introduction"));

        // 프로필 주소를 제거하는 것도 가능
        memberRegister.updateInfo(member.getId(), new MemberInfoUpdateRequest("James", "", "Introduction"));

        // 프로필 주소 중복는 허용하지 않음
        assertThatThrownBy(() -> memberRegister.updateInfo(member.getId(), new MemberInfoUpdateRequest("James", "toby101", "Introduction")))
            .isInstanceOf(DuplicateProfileException.class);

    }

    private Member registerMember() {
        Member member = memberRegister.register(MemberFixture.createMemberRegisterRequest());
        entityManager.flush();
        entityManager.clear();
        return member;
    }

    private Member registerMember(String email) {
        Member member = memberRegister.register(MemberFixture.createMemberRegisterRequest(email));
        entityManager.flush();
        entityManager.clear();
        return member;
    }

}
