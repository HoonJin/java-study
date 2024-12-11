package com.hoonjin.study.spring.advanced.proxy.config.v6;

import com.hoonjin.study.spring.advanced.proxy.config.AppV1Config;
import com.hoonjin.study.spring.advanced.proxy.config.AppV2Config;
import com.hoonjin.study.spring.advanced.proxy.config.v6.aspect.LogTraceAspect;
import com.hoonjin.study.spring.advanced.proxy.trace.logtrace.LogTrace;
import com.hoonjin.study.spring.advanced.proxy.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AppV1Config.class, AppV2Config.class})
public class AopConfig {

    @Bean
    public LogTraceAspect logTraceAspect(LogTrace trace) {
        return new LogTraceAspect(trace);
    }

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
