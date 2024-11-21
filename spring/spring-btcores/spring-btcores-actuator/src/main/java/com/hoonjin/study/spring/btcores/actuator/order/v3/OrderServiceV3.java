package com.hoonjin.study.spring.btcores.actuator.order.v3;

import com.hoonjin.study.spring.btcores.actuator.order.OrderService;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RequiredArgsConstructor
public class OrderServiceV3 implements OrderService {

    private final MeterRegistry registry;
    private AtomicInteger stock = new AtomicInteger(100);

    @Override
    public void order() {

        Timer timer = Timer.builder("my.order")
            .tag("class", this.getClass().getName())
            .tag("method", "order")
            .description("order")
            .register(registry);

        timer.record(() -> {
            log.info("주문");
            sleep(300);
            stock.decrementAndGet();
        });
    }

    @Override
    public void cancel() {
        Timer.builder("my.order")
            .tag("class", this.getClass().getName())
            .tag("method", "cancel")
            .description("order")
            .register(registry)
            .record(() -> {
                log.info("취소");
                sleep(200);
                stock.incrementAndGet();
            });
    }

    @Override
    public AtomicInteger getStock() {
        return stock;
    }

    private static void sleep(int l) {
        try {
            Thread.sleep(l + new Random().nextInt(200));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
