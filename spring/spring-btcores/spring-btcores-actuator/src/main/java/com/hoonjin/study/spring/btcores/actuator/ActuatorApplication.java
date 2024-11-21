package com.hoonjin.study.spring.btcores.actuator;

import com.hoonjin.study.spring.btcores.actuator.order.gauge.StockConfigV1;
import com.hoonjin.study.spring.btcores.actuator.order.gauge.StockConfigV2;
import com.hoonjin.study.spring.btcores.actuator.order.v0.OrderConfigV0;
import com.hoonjin.study.spring.btcores.actuator.order.v1.OrderConfigV1;
import com.hoonjin.study.spring.btcores.actuator.order.v2.OrderConfigV2;
import com.hoonjin.study.spring.btcores.actuator.order.v3.OrderConfigV3;
import com.hoonjin.study.spring.btcores.actuator.order.v4.OrderConfigV4;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import(OrderConfigV0.class)
//@Import(OrderConfigV1.class)
//@Import(OrderConfigV2.class)
//@Import(OrderConfigV3.class)
//@Import(OrderConfigV4.class)
//@Import({OrderConfigV4.class, StockConfigV1.class})
@Import({OrderConfigV4.class, StockConfigV2.class})
@SpringBootApplication(scanBasePackages = "com.hoonjin.study.spring.btcores.actuator.controller")
public class ActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActuatorApplication.class, args);
    }

    @Bean
    public InMemoryHttpExchangeRepository exchangeRepository() {
        return new InMemoryHttpExchangeRepository();
    }
}
