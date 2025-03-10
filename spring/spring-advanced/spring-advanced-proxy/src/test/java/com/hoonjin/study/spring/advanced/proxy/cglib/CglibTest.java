package com.hoonjin.study.spring.advanced.proxy.cglib;

import com.hoonjin.study.spring.advanced.proxy.cglib.code.TimeMethodInterceptor;
import com.hoonjin.study.spring.advanced.proxy.common.ConcreteService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

@Slf4j
public class CglibTest {

    @Test
    void cglib() {
        ConcreteService target = new ConcreteService();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConcreteService.class);
        enhancer.setCallback(new TimeMethodInterceptor(target));

        ConcreteService proxy = (ConcreteService) enhancer.create();

        log.info("target.getClass() = " + target.getClass());
        log.info("proxy.getClass() = " + proxy.getClass());

        proxy.call();
    }
}
