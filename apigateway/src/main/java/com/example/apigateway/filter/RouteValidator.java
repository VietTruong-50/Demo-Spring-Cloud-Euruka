package com.example.apigateway.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {
    private static final List<String> publicEndpoints = List.of(
            "/api/v1/auth/login", "/api/v1/auth/register", "/api-docs"
    );

    public Predicate<ServerHttpRequest> isApiSecured =
            request -> publicEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
}
