package com.hoonjin.study.spring.advanced.log.trace.hellotrace;

import com.hoonjin.study.spring.advanced.log.trace.TraceId;
import com.hoonjin.study.spring.advanced.log.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloTraceV1 {

    private static final String START_PREFIX = "-->";
    private static final String COMPLETE_PREFIX = "<--";
    private static final String EX_PREFIX = "<X-";

    public TraceStatus begin(String message) {
        TraceId traceId = new TraceId();
        long start = System.currentTimeMillis();
        log.info("[{}] {}{}", traceId.getId(), addSpace(START_PREFIX, traceId.getLevel()), message);
        return new TraceStatus(traceId, start, message);
    }

    private String addSpace(String prefix, int level) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < level; i++) {
            String s = (i == level - 1) ? "|" + prefix : "|  ";
            stringBuffer.append(s);
        }
        return stringBuffer.toString();
    }

    public void end(TraceStatus status) {
        complete(status, null);
    }

    public void exception(TraceStatus status, Exception e) {
        complete(status, e);
    }

    private void complete(TraceStatus status, Exception e) {
        long stop = System.currentTimeMillis();
        long duration = stop - status.getStartTimeMs();

        TraceId traceId = status.getTraceId();
        if (e == null) {
            log.info("[{}] {}{} time={}ms", traceId.getId(), addSpace(COMPLETE_PREFIX, traceId.getLevel()), status.getMessage(), duration);
        } else {
            log.info("[{}] {}{} time={}ms ex={}", traceId.getId(), addSpace(EX_PREFIX, traceId.getLevel()), status.getMessage(), duration, e.toString());
        }
    }
}
