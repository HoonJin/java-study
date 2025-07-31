package com.hoonjin.study.spring.hello;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

@JdbcTest
public class JdbcTemplateTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void init() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS hello (name VARCHAR(50) primary key, count int)");
    }

    @Test
    void insert() {
        jdbcTemplate.update("INSERT INTO hello (name, count) VALUES (?, ?)", "test", 1);
    }
}
