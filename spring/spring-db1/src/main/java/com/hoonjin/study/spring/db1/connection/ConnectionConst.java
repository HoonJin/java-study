package com.hoonjin.study.spring.db1.connection;

public abstract class ConnectionConst {
    public static final String URL = "jdbc:h2:file:./spring/spring-db1/db";
    public static final String TEST_URL = "jdbc:h2:file:./db"; // 멀티모듈 특성으로 테스트 코드를 위한 추가
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "1234";
}
