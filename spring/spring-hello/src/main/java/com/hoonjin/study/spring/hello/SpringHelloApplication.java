package com.hoonjin.study.spring.hello;

import com.hoonjin.study.spring.config.MySpringBootApplication;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@MySpringBootApplication
@RequiredArgsConstructor
public class SpringHelloApplication {

    private final JdbcTemplate jdbcTemplate;

    @PostConstruct
    void init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringHelloApplication.class, args);
    }

}
