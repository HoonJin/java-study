package com.hoonjin.study.spring.btcores.autoconfig.selector;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

public class ImportSelectorTest {

    @Test
    void staticConfig() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(StaticConfig.class);
        HelloBean bean = ac.getBean(HelloBean.class);

        assertThat(bean).isNotNull();

    }

    @Test
    void selectorConfig() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SelectorConfig.class);
        HelloBean bean = ac.getBean(HelloBean.class);

        assertThat(bean).isNotNull();
    }

    @Configuration
    @Import(HelloConfig.class)
    public static class StaticConfig {

    }

    @Configuration
    @Import(HelloImportSelector.class)
    public static class SelectorConfig {

    }
}
