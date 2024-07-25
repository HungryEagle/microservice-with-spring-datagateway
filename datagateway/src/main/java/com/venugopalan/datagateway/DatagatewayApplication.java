package com.venugopalan.datagateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class DatagatewayApplication {

	@Bean
	public RouteLocator customRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("counterservice", r -> r.path("/counterservice/**")
						.filters(f -> f.stripPrefix(1))
						.uri("lb://COUNTERSERVICE"))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(DatagatewayApplication.class, args);
	}

}
