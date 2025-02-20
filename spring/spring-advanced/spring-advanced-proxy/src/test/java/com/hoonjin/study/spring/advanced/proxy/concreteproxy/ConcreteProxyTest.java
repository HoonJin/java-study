package com.hoonjin.study.spring.advanced.proxy.concreteproxy;

import com.hoonjin.study.spring.advanced.proxy.concreteproxy.code.ConcreteClient;
import com.hoonjin.study.spring.advanced.proxy.concreteproxy.code.ConcreteLogic;
import com.hoonjin.study.spring.advanced.proxy.concreteproxy.code.TimeProxy;
import org.junit.jupiter.api.Test;

public class ConcreteProxyTest {

    @Test
    void noProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient concreteClient = new ConcreteClient(concreteLogic);
        concreteClient.execute();
    }

    @Test
    void addProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        TimeProxy timeProxy = new TimeProxy(concreteLogic);
        ConcreteClient concreteClient = new ConcreteClient(timeProxy);
        concreteClient.execute();
    }
}
