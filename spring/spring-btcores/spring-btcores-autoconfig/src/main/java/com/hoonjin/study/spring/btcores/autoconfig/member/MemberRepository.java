package com.hoonjin.study.spring.btcores.autoconfig.member;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    public final JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void initTable() {
        jdbcTemplate.execute("drop table if exists member");
        jdbcTemplate.execute("create table member(member_id varchar primary key, name varchar)");
    }

    public void save(Member member) {
        jdbcTemplate.update("insert into member(member_id, name) values (?, ?)",
            member.getMemberId(), member.getName()
        );
    }

    public Member find(String memberId) {
        return jdbcTemplate.queryForObject("select member_id, name from member where member_id = ?",
            BeanPropertyRowMapper.newInstance(Member.class),
            memberId
        );
    }

    public List<Member> findAll() {
        return jdbcTemplate.query("select member_id, name from member",
            BeanPropertyRowMapper.newInstance(Member.class)
        );
    }
}
