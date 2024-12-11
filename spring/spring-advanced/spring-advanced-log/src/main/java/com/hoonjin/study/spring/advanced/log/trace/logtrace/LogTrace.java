package com.hoonjin.study.spring.advanced.log.trace.logtrace;

import com.hoonjin.study.spring.advanced.log.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception e);
}
