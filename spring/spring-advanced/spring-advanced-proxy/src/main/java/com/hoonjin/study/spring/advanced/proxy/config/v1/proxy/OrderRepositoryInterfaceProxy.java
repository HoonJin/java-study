package com.hoonjin.study.spring.advanced.proxy.config.v1.proxy;

import com.hoonjin.study.spring.advanced.proxy.app.v1.OrderRepositoryV1;
import com.hoonjin.study.spring.advanced.proxy.trace.TraceStatus;
import com.hoonjin.study.spring.advanced.proxy.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderRepositoryInterfaceProxy implements OrderRepositoryV1 {

    private final OrderRepositoryV1 target;
    private final LogTrace trace;

    @Override
    public void save(String itemId) {
        TraceStatus status = trace.begin("OrderRepository.save()");
        try {
            target.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

}
