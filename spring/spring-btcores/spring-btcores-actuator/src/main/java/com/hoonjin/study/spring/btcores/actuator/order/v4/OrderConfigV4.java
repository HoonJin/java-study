package com.hoonjin.study.spring.btcores.actuator.order.v4;

import com.hoonjin.study.spring.btcores.actuator.order.OrderService;
import com.hoonjin.study.spring.btcores.actuator.order.v2.OrderServiceV2;
import io.micrometer.core.aop.CountedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfigV4 {

    @Bean
    public OrderService orderService() {
        return new OrderServiceV4();
    }

    @Bean
    public CountedAspect countedAspect(MeterRegistry meterRegistry) {
        return new CountedAspect(meterRegistry);
    }
}
