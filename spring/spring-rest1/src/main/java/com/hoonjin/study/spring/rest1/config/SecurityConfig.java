package com.hoonjin.study.spring.rest1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        UserDetails user = User
            .withUsername("user")
            .password(passwordEncoder().encode("password"))
            .authorities("read")
            .build();

        inMemoryUserDetailsManager.createUser(user);
        return inMemoryUserDetailsManager;

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
//        new WebSecurityCustomizer() {
//            @Override
//            public void customize(WebSecurity web) {
//            }
//        };
        return (web) -> web.ignoring()
            .requestMatchers(new AntPathRequestMatcher("/h2-console/**"))
            .requestMatchers(new AntPathRequestMatcher("/jpa/**"));
    }
}
