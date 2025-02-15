package com.hoonjin.study.spring.advanced.log.trace.strategy;

import com.hoonjin.study.spring.advanced.log.trace.strategy.code.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {

    @Test
    void callbackV1() {
        TimeLogTemplate timeLogTemplate = new TimeLogTemplate();
        timeLogTemplate.execute(() -> log.info("callback logic run"));
    }
}
