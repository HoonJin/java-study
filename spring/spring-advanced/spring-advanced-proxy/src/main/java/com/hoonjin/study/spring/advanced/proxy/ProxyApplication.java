package com.hoonjin.study.spring.advanced.proxy;

import com.hoonjin.study.spring.advanced.proxy.config.AppV1Config;
import com.hoonjin.study.spring.advanced.proxy.config.AppV2Config;
import com.hoonjin.study.spring.advanced.proxy.config.v1.ConcreteProxyConfig;
import com.hoonjin.study.spring.advanced.proxy.config.v1.InterfaceProxyConfig;
import com.hoonjin.study.spring.advanced.proxy.config.v2.DynamicProxyBasicConfig;
import com.hoonjin.study.spring.advanced.proxy.config.v2.DynamicProxyFilterConfig;
import com.hoonjin.study.spring.advanced.proxy.config.v3.ProxyFactoryConfigV1;
import com.hoonjin.study.spring.advanced.proxy.config.v3.ProxyFactoryConfigV2;
import com.hoonjin.study.spring.advanced.proxy.config.v4.BeanPostProcessorConfig;
import com.hoonjin.study.spring.advanced.proxy.config.v5.AutoProxyConfig;
import com.hoonjin.study.spring.advanced.proxy.config.v6.AopConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = "com.hoonjin.study.spring.advanced.proxy.app")
//@Import({AppV1Config.class, AppV2Config.class})
//@Import(InterfaceProxyConfig.class)
//@Import(ConcreteProxyConfig.class)
//@Import(DynamicProxyBasicConfig.class)
//@Import(DynamicProxyFilterConfig.class)
//@Import(ProxyFactoryConfigV1.class)
//@Import(ProxyFactoryConfigV2.class)
//@Import(BeanPostProcessorConfig.class)
//@Import(AutoProxyConfig.class)
@Import(AopConfig.class)
public class ProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxyApplication.class, args);
    }
}
