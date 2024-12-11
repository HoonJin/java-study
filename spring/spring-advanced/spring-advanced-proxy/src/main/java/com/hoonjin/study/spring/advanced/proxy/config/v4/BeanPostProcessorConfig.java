package com.hoonjin.study.spring.advanced.proxy.config.v4;

import com.hoonjin.study.spring.advanced.proxy.config.AppV1Config;
import com.hoonjin.study.spring.advanced.proxy.config.AppV2Config;
import com.hoonjin.study.spring.advanced.proxy.config.v3.advice.LogTraceAdvice;
import com.hoonjin.study.spring.advanced.proxy.config.v4.postprocessor.PackageLogTraceProxyPostProcessor;
import com.hoonjin.study.spring.advanced.proxy.trace.logtrace.LogTrace;
import com.hoonjin.study.spring.advanced.proxy.trace.logtrace.ThreadLocalLogTrace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Slf4j
@Configuration
@Import({AppV1Config.class, AppV2Config.class})
public class BeanPostProcessorConfig {

    @Bean
    public PackageLogTraceProxyPostProcessor proxyPostProcessor(LogTrace trace) {
        return new PackageLogTraceProxyPostProcessor("com.hoonjin.study.spring.advanced.proxy.app", getAdvisor(trace));
    }

    private Advisor getAdvisor(LogTrace trace) {
        // point cut
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*", "order*", "save*");
        LogTraceAdvice advice = new LogTraceAdvice(trace);
        return new DefaultPointcutAdvisor(pointcut, advice);
    }

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
