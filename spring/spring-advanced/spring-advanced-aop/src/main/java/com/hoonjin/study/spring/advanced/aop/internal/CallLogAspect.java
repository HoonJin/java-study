package com.hoonjin.study.spring.advanced.aop.internal;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Slf4j
@Aspect
public class CallLogAspect {

    @Before("execution(* com.hoonjin.study.spring.advanced.aop.internal..*.*(..))")
    public void log(JoinPoint joinPoint) {
        log.info("aop={}", joinPoint.getSignature());
    }
}
