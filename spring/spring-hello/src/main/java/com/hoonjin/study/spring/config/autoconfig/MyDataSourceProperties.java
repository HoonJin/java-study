package com.hoonjin.study.spring.config.autoconfig;

import com.hoonjin.study.spring.config.MyConfigurationProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MyConfigurationProperties(prefix = "data")
public class MyDataSourceProperties {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
}
