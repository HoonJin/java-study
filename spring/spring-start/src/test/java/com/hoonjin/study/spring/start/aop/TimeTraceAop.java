package com.hoonjin.study.spring.start.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    @Around("execution(* com.hoonjin.study.spring.start..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long duration = finish - start;
            System.out.println("exec1" + joinPoint.toString() + " = " + duration + "ms");
        }
    }

    @Around("execution(* com.hoonjin.study.spring.start..*(..))")
    public Object execute2(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long duration = finish - start;
            System.out.println("exec2" + joinPoint.toString() + " = " + duration + "ms");
        }
    }
}
