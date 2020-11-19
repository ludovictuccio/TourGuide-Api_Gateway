package com.tourGuide.apiGateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tourGuide.apiGateway.filters.LoggingGatewayFilterFactory;
import com.tourGuide.apiGateway.filters.LoggingGatewayFilterFactory.Config;

@Configuration
@EnableDiscoveryClient
public class GatewayDiscoveryConfiguration {

    @Autowired
    private LoggingGatewayFilterFactory loggingFactory;

    private static final String URI_MICROSERVICE_USER_9001 = "http://localhost:9001/";
    private static final String URI_MICROSERVICE_GPS_9002 = "http://localhost:9002/";
    private static final String URI_MICROSERVICE_REWARDS_9003 = "http://localhost:9003/";

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes().route(r -> r.path("/user/**").filters(
                f -> f.filter(loggingFactory.apply(new Config(true, true))))
                .uri(URI_MICROSERVICE_USER_9001))
                .route(r -> r.path("/gps/**")
                        .filters(f -> f.filter(
                                loggingFactory.apply(new Config(true, true))))
                        .uri(URI_MICROSERVICE_GPS_9002))
                .route(r -> r.path("/rewards/**")
                        .filters(f -> f.filter(
                                loggingFactory.apply(new Config(true, true))))
                        .uri(URI_MICROSERVICE_REWARDS_9003))
                .build();
    }

}
