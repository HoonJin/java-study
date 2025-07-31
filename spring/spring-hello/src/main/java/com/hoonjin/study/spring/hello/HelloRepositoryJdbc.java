package com.hoonjin.study.spring.hello;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class HelloRepositoryJdbc implements HelloRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Hello findHello(String name) {
        try {
            return jdbcTemplate.queryForObject("select name, count from hello where name = '" + name + "'",
                (rs, rowNum) -> new Hello(rs.getString("name"), rs.getInt("count")));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void increaseCount(String name) {
        Hello hello = findHello(name);
        if (hello == null) {
            jdbcTemplate.update("INSERT INTO hello (name, count) VALUES (?, ?)", name, 1);
        } else {
            jdbcTemplate.update("UPDATE hello SET count = count + 1 where name = '" + name + "'");
        }
    }
}
