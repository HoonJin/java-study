package com.hoonjin.study.spring.splearn.application.required;

import com.hoonjin.study.spring.splearn.domain.Email;
import com.hoonjin.study.spring.splearn.domain.Member;
import org.springframework.data.repository.Repository;

import java.util.Optional;

// 회원 정보 저장, 조회
public interface MemberRepository extends Repository<Member, Long> {

    Member save(Member member);

    Optional<Member> findByEmail(Email email);

}
