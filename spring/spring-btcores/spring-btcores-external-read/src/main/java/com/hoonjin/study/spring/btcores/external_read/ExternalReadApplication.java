package com.hoonjin.study.spring.btcores.external_read;

import com.hoonjin.study.spring.btcores.external_read.config.MyDatasourceEnvConfig;
import com.hoonjin.study.spring.btcores.external_read.config.MyDatasourceValueConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

//@Import(MyDatasourceEnvConfig.class)
@Import(MyDatasourceValueConfig.class)
@SpringBootApplication(scanBasePackages = "com.hoonjin.study.spring.btcores.external_read.datasource")
public class ExternalReadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExternalReadApplication.class, args);
    }
}
