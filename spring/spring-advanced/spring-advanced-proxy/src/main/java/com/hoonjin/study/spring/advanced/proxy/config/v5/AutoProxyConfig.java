package com.hoonjin.study.spring.advanced.proxy.config.v5;

import com.hoonjin.study.spring.advanced.proxy.config.AppV1Config;
import com.hoonjin.study.spring.advanced.proxy.config.AppV2Config;
import com.hoonjin.study.spring.advanced.proxy.config.v3.advice.LogTraceAdvice;
import com.hoonjin.study.spring.advanced.proxy.trace.logtrace.LogTrace;
import com.hoonjin.study.spring.advanced.proxy.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AppV1Config.class, AppV2Config.class})
public class AutoProxyConfig {

//    @Bean
    public Advisor logAdvisor(LogTrace trace) {
        // point cut
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*", "order*", "save*");
        LogTraceAdvice advice = new LogTraceAdvice(trace);
        return new DefaultPointcutAdvisor(pointcut, advice);
    }

//    @Bean
    public Advisor logAdvisor2(LogTrace trace) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* com.hoonjin.study.spring.advanced.proxy.app..*(..))");
        LogTraceAdvice advice = new LogTraceAdvice(trace);
        return new DefaultPointcutAdvisor(pointcut, advice);
    }

    @Bean
    public Advisor logAdvisor3(LogTrace trace) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* com.hoonjin.study.spring.advanced.proxy.app..*(..)) && !execution(* com.hoonjin.study.spring.advanced.proxy.app..noLog(..))");
        LogTraceAdvice advice = new LogTraceAdvice(trace);
        return new DefaultPointcutAdvisor(pointcut, advice);
    }

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
