package com.hoonjin.study.spring.config.autoconfig;

import com.hoonjin.study.spring.config.MyAutoConfiguration;
import com.hoonjin.study.spring.config.MyConfigurationProperties;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;

@MyAutoConfiguration
public class PropertyPostProcessorConfig {

    @Bean
    public static BeanPostProcessor beanPostProcessor(Environment environment) {
        return new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) {
                MyConfigurationProperties annotation = AnnotationUtils.findAnnotation(bean.getClass(), MyConfigurationProperties.class);
                if (annotation == null) return bean;

                String prefix = annotation.prefix();

                //                Binder.get(environment)
//                    .bind(prefix, bean.getClass())
//                    .ifBound(bound -> BeanUtils.copyProperties(bound, bean));
//
//                return bean;
                return Binder.get(environment)
                    .bindOrCreate(prefix, bean.getClass());
            }
        };
    }
}
