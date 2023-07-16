package com.example.apigateway.config;

import com.example.apigateway.filter.AuthTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Autowired
    AuthTokenFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("authentication-service", r -> r.path("/api/v1/auth/**")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:9001/"))

                .route("product-service", r -> r.path("/api/v1/product/**")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:9002/"))

                .route("order-service", r -> r.path("/api/v1/order/**")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:9003/"))

                .route("inventory-service", r -> r.path("/api/v1/inventory/**")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:9004/"))

                .route("user-service", r -> r.path("/api/v1/user/**")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:9005/"))
                .build();
    }
}