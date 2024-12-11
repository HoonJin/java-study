package com.hoonjin.study.spring.advanced.log.trace.logtrace;

import com.hoonjin.study.spring.advanced.log.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class FieldLogTraceTest {

    FieldLogTrace trace = new FieldLogTrace();

    @Test
    void begin_end_level2() {
        TraceStatus status1 = trace.begin("trace1");
        TraceStatus status2 = trace.begin("trace2");
        trace.end(status2);
        trace.end(status1);
    }

}