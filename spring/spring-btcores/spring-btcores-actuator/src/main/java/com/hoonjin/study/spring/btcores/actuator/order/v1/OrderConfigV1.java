package com.hoonjin.study.spring.btcores.actuator.order.v1;

import com.hoonjin.study.spring.btcores.actuator.order.OrderService;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfigV1 {

    @Bean
    public OrderService orderService(MeterRegistry meterRegistry) {
        return new OrderServiceV1(meterRegistry);
    }
}
