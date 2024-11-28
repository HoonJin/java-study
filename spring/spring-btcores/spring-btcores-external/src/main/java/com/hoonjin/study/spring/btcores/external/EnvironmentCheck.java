package com.hoonjin.study.spring.btcores.external;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EnvironmentCheck {

    private final Environment env;

    @PostConstruct
    public void init() {
        String url = env.getProperty("url");
        log.info("env url = {}", url);
        String username = env.getProperty("username");
        log.info("env username = {}", username);
        String password = env.getProperty("password");
        log.info("env password = {}", password);

    }
}
