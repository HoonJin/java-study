package com.hoonjin.study.spring.btcores.external_read.config;

import com.hoonjin.study.spring.btcores.external_read.datasource.MyDataSource;
import com.hoonjin.study.spring.btcores.external_read.datasource.MyDataSourcePropertiesV1;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties(MyDataSourcePropertiesV1.class)
@RequiredArgsConstructor
public class MyDataSourceConfigV1 {

    private final MyDataSourcePropertiesV1 properties;

    @Bean
    public MyDataSource myDataSource1() {
        return new MyDataSource(
            properties.getUrl(),
            properties.getUsername(),
            properties.getPassword(),
            properties.getEtc().getMaxConnection(),
            properties.getEtc().getTimeout(),
            properties.getEtc().getOptions()
        );
    }
}
