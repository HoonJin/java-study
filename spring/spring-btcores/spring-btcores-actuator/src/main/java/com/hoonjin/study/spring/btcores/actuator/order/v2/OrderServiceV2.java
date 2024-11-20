package com.hoonjin.study.spring.btcores.actuator.order.v2;

import com.hoonjin.study.spring.btcores.actuator.order.OrderService;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RequiredArgsConstructor
public class OrderServiceV2 implements OrderService {

    private AtomicInteger stock = new AtomicInteger(100);

    @Override
    @Counted(value = "my.order", description = "order")
    public void order() {
        log.info("주문");
        stock.decrementAndGet();
    }

    @Override
    @Counted(value = "my.order", description = "order")
    public void cancel() {
        log.info("취소");
        stock.incrementAndGet();
    }

    @Override
    public AtomicInteger getStock() {
        return stock;
    }
}
