package com.tourGuide.apiGateway.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDiscoveryClient
public class GatewayDiscoveryConfiguration {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/users/**").uri("http://localhost:9001/"))
                .route(r -> r.path("/gps/**").uri("http://localhost:9002/"))
                .route(r -> r.path("/rewards/**").uri("http://localhost:9003/"))
                .build();
    }
}
