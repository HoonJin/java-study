package com.hoonjin.study.spring.splearn.adapter.security;

import com.hoonjin.study.spring.splearn.domain.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecurePasswordEncoder implements PasswordEncoder {

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public String encode(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    @Override
    public boolean matches(String password, String PasswordHash) {
        return bCryptPasswordEncoder.matches(password, PasswordHash);
    }
}
