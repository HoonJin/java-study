package com.hoonjin.study.spring.advanced.proxy.config.v1;

import com.hoonjin.study.spring.advanced.proxy.app.v1.*;
import com.hoonjin.study.spring.advanced.proxy.config.v1.proxy.OrderControllerInterfaceProxy;
import com.hoonjin.study.spring.advanced.proxy.config.v1.proxy.OrderRepositoryInterfaceProxy;
import com.hoonjin.study.spring.advanced.proxy.config.v1.proxy.OrderServiceInterfaceProxy;
import com.hoonjin.study.spring.advanced.proxy.trace.logtrace.LogTrace;
import com.hoonjin.study.spring.advanced.proxy.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterfaceProxyConfig {

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }

    @Bean
    public OrderRepositoryV1 orderRepository(LogTrace trace) {
        return new OrderRepositoryInterfaceProxy(new OrderRepositoryV1Impl(), trace);
    }

    @Bean
    public OrderServiceV1 orderService(LogTrace trace) {
        return new OrderServiceInterfaceProxy(new OrderServiceV1Impl(orderRepository(trace)), trace);
    }

    @Bean
    public OrderControllerV1 orderController(LogTrace trace) {
        return new OrderControllerInterfaceProxy(new OrderControllerV1Impl(orderService(trace)), trace);
    }
}
