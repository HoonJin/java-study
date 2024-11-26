package com.hoonjin.study.spring.btcores.actuator.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class TrafficController {

    @GetMapping("/cpu")
    public String cpu() {
        log.info("CPU");
        long value = 0;
        for (long i = 0; i < 100_000_000_000L; i++) {
            value++;
        }
        return "cpu" + value;
    }

    private List<String> list = new ArrayList<>();

    @GetMapping("/jvm")
    public String jvm() {
        log.info("JVM");
        for (long i = 0; i < 100_000; i++) {
            list.add("hello" + i);
        }
        return "jvm";
    }

    @Autowired
    DataSource dataSource;

    @GetMapping("/jdbc")
    public String jdbc() throws SQLException {
        log.info("JDBC");
        Connection connection = dataSource.getConnection();
        log.info("connection = {}", connection);
        return "jdbc";
    }

    @GetMapping("/error-log")
    public String errorLog() {
        log.error("error log");
        return "error";
    }
}
