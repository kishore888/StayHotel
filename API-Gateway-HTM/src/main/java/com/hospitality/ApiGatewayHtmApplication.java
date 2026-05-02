package com.hospitality;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayHtmApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayHtmApplication.class, args);
	}

//	@Bean
//	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route("roomBookingRoute", routeSepc ->routeSepc.path("/room/**") 
//						.filters(f -> f.addResponseHeader("X-Response-Header", "SCS"))
//				//.uri("http://localhost:8880/")
//				.uri("lb://Room_Service")
//				)
//				.build();
//	}
	
}
