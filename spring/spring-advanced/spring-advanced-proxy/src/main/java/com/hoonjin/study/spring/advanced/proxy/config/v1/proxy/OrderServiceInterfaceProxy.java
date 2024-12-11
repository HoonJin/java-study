package com.hoonjin.study.spring.advanced.proxy.config.v1.proxy;

import com.hoonjin.study.spring.advanced.proxy.app.v1.OrderServiceV1;
import com.hoonjin.study.spring.advanced.proxy.trace.TraceStatus;
import com.hoonjin.study.spring.advanced.proxy.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderServiceInterfaceProxy implements OrderServiceV1 {

    private final OrderServiceV1 target;
    private final LogTrace trace;

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
