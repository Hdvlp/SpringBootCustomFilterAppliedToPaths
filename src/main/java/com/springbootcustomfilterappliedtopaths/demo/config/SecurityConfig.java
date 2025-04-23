package com.springbootcustomfilterappliedtopaths.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    @Order(100)
    SecurityFilterChain securityFilterChainApiV1(HttpSecurity http) throws Exception {
        String[] matchedPaths = { "/api/v1/" };
        http
            .csrf(AbstractHttpConfigurer::disable)
            .securityMatcher(matchedPaths)
            .authorizeHttpRequests(
                auth -> 
                    auth
                    .requestMatchers(matchedPaths)
                    .permitAll()
            );

        return http.build();
    }

    @Bean
    @Order(200)
    SecurityFilterChain securityFilterChainApiAsterisks(HttpSecurity http) throws Exception {
        String[] matchedPaths = { "/api/*" };
        http
            .csrf(AbstractHttpConfigurer::disable)
            .securityMatcher(matchedPaths)
            .authorizeHttpRequests(
                auth -> 
                    auth
                    .requestMatchers(matchedPaths)
                    .permitAll()
            );

        return http.build();
    }

    @Bean
    @Order(300)
    SecurityFilterChain securityFilterChainUsersUserId(HttpSecurity http) throws Exception {
        String[] matchedPaths = { "/*/users/{userId}/**" };
        http
            .csrf(AbstractHttpConfigurer::disable)
            .securityMatcher(matchedPaths)
            .authorizeHttpRequests(
                auth -> 
                    auth
                    .requestMatchers(matchedPaths)
                    .permitAll()
            );

        return http.build();
    }


    @Bean
    public CustomFilter customFilter(){
        return new CustomFilter();
    }

}
