package com.hoonjin.study.spring.advanced.log.trace.callback;

public interface TraceCallback<T> {

    T call();
}
