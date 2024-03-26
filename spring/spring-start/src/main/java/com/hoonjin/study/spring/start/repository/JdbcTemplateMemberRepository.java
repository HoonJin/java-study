package com.hoonjin.study.spring.start.repository;

import com.hoonjin.study.spring.start.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class JdbcTemplateMemberRepository implements MemberRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateMemberRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Member save(Member member) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id");

        HashMap<String, Object> params = new HashMap<>();
        params.put("name", member.getName());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(params));
        member.setId(key.longValue());
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        String sql = "select * from member where id = ?";
        List<Member> query = jdbcTemplate.query(sql, memberRowMapper(), id);
        return query.stream().findAny();
    }

    @Override
    public Optional<Member> findByName(String name) {
        String sql = "select * from member where name = ?";
        List<Member> query = jdbcTemplate.query(sql, memberRowMapper(), name);
        return query.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        String sql = "select * from member";
        return jdbcTemplate.query(sql, memberRowMapper());
    }

    private RowMapper<Member> memberRowMapper() {
        return (ResultSet rs, int rowNum) -> {
            Member member = new Member();
            member.setId(rs.getLong("id"));
            member.setName(rs.getString("name"));
            return member;
        };
    }
}
