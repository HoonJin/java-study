package com.hoonjin.study.spring.db1.connection;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.hoonjin.study.spring.db1.connection.ConnectionConst.*;

@Slf4j
class ConnectionConstTest {

    @Test
    void driverManager() throws SQLException {
        Connection conn1 = DriverManager.getConnection(TEST_URL, USERNAME, PASSWORD);
        Connection conn2 = DriverManager.getConnection(TEST_URL, USERNAME, PASSWORD);

        log.info("conn={}", conn1);
        log.info("conn={}", conn2);
    }

    @Test
    void dataSourceDriverManager() throws SQLException {
        DataSource dataSource = new DriverManagerDataSource(TEST_URL, USERNAME, PASSWORD);

        useDataSource(dataSource);
    }

    private void useDataSource(DataSource dataSource) throws SQLException {
        // driverManager와 다르게 설정과 사용이 분리되어있다.
        Connection conn1 = dataSource.getConnection();
        Connection conn2 = dataSource.getConnection();

        log.info("conn={}", conn1);
        log.info("conn={}", conn2);
    }

    @Test
    void dataSourceConnectionPool() throws SQLException, InterruptedException {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(TEST_URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        dataSource.setMaximumPoolSize(10);
        dataSource.setPoolName("MyPool");

        useDataSource(dataSource);
        Thread.sleep(1000); // connection pool 생성한 것 확인하기 위한 sleep
    }
}