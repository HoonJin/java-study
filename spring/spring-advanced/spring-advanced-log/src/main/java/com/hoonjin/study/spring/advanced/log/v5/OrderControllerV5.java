package com.hoonjin.study.spring.advanced.log.v5;

import com.hoonjin.study.spring.advanced.log.trace.callback.TraceTemplate;
import com.hoonjin.study.spring.advanced.log.trace.logtrace.LogTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

    private final OrderServiceV5 orderServiceV5;
    private final TraceTemplate traceTemplate;

    public OrderControllerV5(OrderServiceV5 orderServiceV5, LogTrace trace) {
        this.orderServiceV5 = orderServiceV5;
        this.traceTemplate = new TraceTemplate(trace);
    }

    @GetMapping("/v5/request")
    public String request(String itemId) {
        return traceTemplate.execute("OrderControllerV5.request()", () -> {
            orderServiceV5.orderItem(itemId);
            return "ok";
        });
    }
}
