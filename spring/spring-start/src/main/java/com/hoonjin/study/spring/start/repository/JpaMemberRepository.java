package com.hoonjin.study.spring.start.repository;

import com.hoonjin.study.spring.start.domain.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
//        em.getReference(Member.class, id)
        return Optional.ofNullable(em.find(Member.class, id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
             .setParameter("name", name)
             .getResultStream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
            .getResultList();
    }
}
