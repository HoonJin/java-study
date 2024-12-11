package com.hoonjin.study.spring.advanced.log.config;

import com.hoonjin.study.spring.advanced.log.trace.logtrace.LogTrace;
import com.hoonjin.study.spring.advanced.log.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
