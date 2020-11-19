package com.tourGuide.apiGateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Mono;

@Configuration
public class LoggingGlobalFiltersConfigurations {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(LoggingGlobalFiltersConfigurations.class);

    @Bean
    public GlobalFilter postGlobalFilter() {
        return (exchange, chain) -> {
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                LOGGER.info("Global Post Filter executed");
            }));
        };
    }
}
