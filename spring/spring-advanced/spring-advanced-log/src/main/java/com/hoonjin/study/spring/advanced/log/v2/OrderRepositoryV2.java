package com.hoonjin.study.spring.advanced.log.v2;

import com.hoonjin.study.spring.advanced.log.trace.TraceId;
import com.hoonjin.study.spring.advanced.log.trace.TraceStatus;
import com.hoonjin.study.spring.advanced.log.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {

    private final HelloTraceV2 trace;

    public void save(String itemId, TraceId traceId) {
        TraceStatus status = trace.beginSync(traceId, "OrderRepository.save()");
        try {
            if (itemId.equals("ex")) {
                throw new IllegalStateException("exception");
            }

            sleep(1000);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    private void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
