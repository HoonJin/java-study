package com.hoonjin.study.spring.btcores.actuator.order.v3;

import com.hoonjin.study.spring.btcores.actuator.order.OrderService;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfigV3 {

    @Bean
    public OrderService orderService(MeterRegistry meterRegistry) {
        return new OrderServiceV3(meterRegistry);
    }
}
