package com.hoonjin.study.spring.advanced.proxy.proxy.code;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProxyPatternClient {

    private final Subject subject;

    public void execute() {
        subject.operation();
    }
}
