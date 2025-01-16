package com.hoonjin.study.java.ionetwork.network.tcp.autocloseable;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ResourceV1 {

    private final String name;

    public void call() {
        System.out.println(name + " call");
    }

    public void callEx() throws CallException {
        System.out.println(name + " callEx");
        throw new CallException(name + " ex");
    }

    public void close() {
        System.out.println(name + " close");
    }

    public void closeEx() throws CloseException {
        System.out.println(name + " closeEx");
        throw new CloseException(name + " close");
    }
}
