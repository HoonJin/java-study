package com.hoonjin.study.spring.rest1.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
    info = @Info(
        title = "test api",
        description = "restful testapi documentation",
        version = "0.0.1"
    )
)
@Configuration
public class SpringDocConfig {

    public GroupedOpenApi customTestOpenApi() {
        String[] paths = {"/users/**", "/admin/**"};
        return GroupedOpenApi.builder()
            .group("일반 사용자와 어드민 사용자를 위한 API")
            .pathsToMatch(paths)
            .build();
    }
}
