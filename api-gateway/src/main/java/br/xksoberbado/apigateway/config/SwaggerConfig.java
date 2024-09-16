package br.xksoberbado.apigateway.config;

import lombok.RequiredArgsConstructor;
import org.springdoc.core.properties.SwaggerUiConfigParameters;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.gateway.server.mvc.config.GatewayMvcProperties;
import org.springframework.cloud.gateway.server.mvc.config.RouteProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

    private final GatewayMvcProperties gatewayMvcProperties;

    @Bean
    public CommandLineRunner openApiGroups(final SwaggerUiConfigParameters swaggerUiParameters) {
        return args -> gatewayMvcProperties.getRoutes()
            .stream()
            .map(RouteProperties::getId)
            .forEach(swaggerUiParameters::addGroup);
    }
}
