package com.hoonjin.study.spring.btcores.external_read.config;

import com.hoonjin.study.spring.btcores.external_read.datasource.MyDataSource;
import com.hoonjin.study.spring.btcores.external_read.datasource.MyDataSourcePropertiesV3;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@ConfigurationPropertiesScan(basePackages = "com.hoonjin.study.spring.btcores.external_read")
@RequiredArgsConstructor
public class MyDataSourceConfigV3 {

    private final MyDataSourcePropertiesV3 properties;

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
