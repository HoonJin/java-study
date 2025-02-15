package com.hoonjin.study.spring.advanced.proxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealComponent implements Component {
    @Override
    public String operation() {
        log.info("real data");
        return "data";
    }
}
