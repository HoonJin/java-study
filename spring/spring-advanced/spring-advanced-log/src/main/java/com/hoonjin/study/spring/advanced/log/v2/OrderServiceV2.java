package com.hoonjin.study.spring.advanced.log.v2;

import com.hoonjin.study.spring.advanced.log.trace.TraceId;
import com.hoonjin.study.spring.advanced.log.trace.TraceStatus;
import com.hoonjin.study.spring.advanced.log.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepositoryV2;
    private final HelloTraceV2 trace;

    public void orderItem(String itemId, TraceId traceId) {
        TraceStatus status = trace.beginSync(traceId, "OrderService.orderItem()");
        try {
            orderRepositoryV2.save(itemId, status.getTraceId());
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

}
