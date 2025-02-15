package com.hoonjin.study.spring.advanced.proxy.config.v1.concreteproxy;

import com.hoonjin.study.spring.advanced.proxy.app.v2.OrderServiceV2;
import com.hoonjin.study.spring.advanced.proxy.trace.TraceStatus;
import com.hoonjin.study.spring.advanced.proxy.trace.logtrace.LogTrace;

public class OrderServiceConcreteProxy extends OrderServiceV2 {

    private final OrderServiceV2 target;
    private final LogTrace trace;

    public OrderServiceConcreteProxy(OrderServiceV2 target, LogTrace trace) {
        super(null);
        this.target = target;
        this.trace = trace;
    }

    @Override
    public void orderItem(String itemId) {
        TraceStatus status = trace.begin("OrderService.orderItem()");
        try {
            target.orderItem(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
