package com.hoonjin.study.spring.splearn.domain;

public interface PasswordEncoder {

    String encode(String password);

    boolean matches(String password, String PasswordHash);

}
