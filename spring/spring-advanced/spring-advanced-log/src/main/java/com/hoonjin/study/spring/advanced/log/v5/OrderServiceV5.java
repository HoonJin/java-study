package com.hoonjin.study.spring.advanced.log.v5;

import com.hoonjin.study.spring.advanced.log.trace.callback.TraceTemplate;
import com.hoonjin.study.spring.advanced.log.trace.logtrace.LogTrace;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepositoryV5;
    private final TraceTemplate traceTemplate;

    public OrderServiceV5(OrderRepositoryV5 orderRepositoryV5, LogTrace trace) {
        this.orderRepositoryV5 = orderRepositoryV5;
        this.traceTemplate = new TraceTemplate(trace);
    }

    public void orderItem(String itemId) {
        traceTemplate.execute("OrderService.orderItem()", () -> {
            orderRepositoryV5.save(itemId);
            return null;
        });
    }

}
