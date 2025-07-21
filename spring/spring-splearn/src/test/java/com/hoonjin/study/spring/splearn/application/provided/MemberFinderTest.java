package com.hoonjin.study.spring.splearn.application.provided;

import com.hoonjin.study.spring.splearn.SplearnTestConfiguration;
import com.hoonjin.study.spring.splearn.domain.Member;
import com.hoonjin.study.spring.splearn.domain.MemberFixture;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Import(SplearnTestConfiguration.class)
record MemberFinderTest(
    MemberFinder memberFinder,
    MemberRegister memberRegister,
    EntityManager entityManager
) {

    @Test
    void find() {
        Member member = memberRegister.register(MemberFixture.createMemberRegisterRequest());
        entityManager.flush();
        entityManager.clear();

        var found = memberFinder.find(member.getId());

        assertThat(found.getId()).isEqualTo(member.getId());
    }

    @Test
    void findFail() {
        Assertions.assertThatThrownBy(() -> memberFinder.find(2L))
            .isInstanceOf(NoSuchElementException.class);

    }
}
