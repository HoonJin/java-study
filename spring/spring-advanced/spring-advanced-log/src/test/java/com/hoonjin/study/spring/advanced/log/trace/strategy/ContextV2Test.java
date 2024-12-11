package com.hoonjin.study.spring.advanced.log.trace.strategy;

import com.hoonjin.study.spring.advanced.log.trace.strategy.code.ContextV2;
import com.hoonjin.study.spring.advanced.log.trace.strategy.code.StrategyLogic1;
import com.hoonjin.study.spring.advanced.log.trace.strategy.code.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    @Test
    void strategyV1() {
        ContextV2 context = new ContextV2();
        context.execute(new StrategyLogic1());
        context.execute(new StrategyLogic2());
        context.execute(() -> log.info("logic temp started"));
    }

}
