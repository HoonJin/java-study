package com.hoonjin.study.spring.advanced.log.v4;

import com.hoonjin.study.spring.advanced.log.trace.logtrace.LogTrace;
import com.hoonjin.study.spring.advanced.log.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {

    private final OrderRepositoryV4 orderRepositoryV4;
    private final LogTrace trace;

    public void orderItem(String itemId) {
        new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {
                orderRepositoryV4.save(itemId);
                return null;
            }
        }.execute("OrderService.orderItem()");
    }

}
