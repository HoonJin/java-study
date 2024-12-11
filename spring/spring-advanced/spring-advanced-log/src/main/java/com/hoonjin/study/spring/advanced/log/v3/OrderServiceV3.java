package com.hoonjin.study.spring.advanced.log.v3;

import com.hoonjin.study.spring.advanced.log.trace.TraceStatus;
import com.hoonjin.study.spring.advanced.log.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

    private final OrderRepositoryV3 orderRepositoryV3;
    private final LogTrace trace;

    public void orderItem(String itemId) {
        TraceStatus status = trace.begin("OrderService.orderItem()");
        try {
            orderRepositoryV3.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

}
