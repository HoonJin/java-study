package com.hoonjin.study.java.ionetwork.network.tcp.autocloseable;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ResourceV2 implements AutoCloseable {

    private final String name;

    public void call() {
        System.out.println(name + " call");
    }

    public void callEx() throws CallException {
        System.out.println(name + " callEx");
        throw new CallException(name + " ex");
    }

    @Override
    public void close() throws CloseException {
        System.out.println(name + " close");
        throw new CloseException(name + " close");
    }

}
