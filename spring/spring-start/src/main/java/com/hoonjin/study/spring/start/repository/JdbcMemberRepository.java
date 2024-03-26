package com.hoonjin.study.spring.start.repository;

import com.hoonjin.study.spring.start.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class JdbcMemberRepository implements MemberRepository {

    private final DataSource dataSource;

    @Override
    public Member save(Member member) {
       return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
