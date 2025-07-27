package com.hoonjin.study.spring.config.autoconfig;

import com.hoonjin.study.spring.config.MyConfigurationProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MyConfigurationProperties(prefix = "myserver")
public class ServerProperties {

    private String contextPath;

    private int port;
}
