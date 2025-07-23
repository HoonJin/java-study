package com.hoonjin.study.spring.splearn.application.member.required;

import com.hoonjin.study.spring.splearn.domain.shared.Email;
import com.hoonjin.study.spring.splearn.domain.member.Member;
import org.springframework.data.repository.Repository;

import java.util.Optional;

// 회원 정보 저장, 조회
public interface MemberRepository extends Repository<Member, Long> {

    Member save(Member member);

    Optional<Member> findByEmail(Email email);

    Optional<Member> findById(Long memberId);

}
