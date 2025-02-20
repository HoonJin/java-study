package com.hoonjin.study.spring.msa.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 비활성화
//@Configuration
public class FilterConfig {
    //    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
            .route(r -> r.path("/first-service/**")
                .filters(f -> f.addRequestHeader("First-Request-Id", "header1")
                    .addResponseHeader("first-response", "response"))
                .uri("http://localhost:8081"))
            .route(r -> r.path("/second-service/**")
                .filters(f -> f.addRequestHeader("Second-Request", "header2")
                    .addResponseHeader("second-response", "response"))
                .uri("http://localhost:8082"))
            .build();
    }
}
