package com.hospitality;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudRoutesConfig {

//	@Value("${app.angular}")
//	private String frontend="";
//	
//	@Value("${app.api}")
//	private String api="";
	
	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
//				.route(r -> r.path("/**").uri("http://localhost:4200"))
				.route("Admin" ,r -> r.path("/admin/**").uri("lb://Admin"))
				.route("ROOM-SERVICE" ,r -> r.path("/room/**").uri("lb://RoomBooking"))
				.route("KPI-Chatbot" ,r -> r.path("/kpi/chatbot/**").uri("lb://KPIChatbot"))
				.route("Payment" ,r -> r.path("/payment/**").uri("lb://Payment"))
				.route("Employee" ,r -> r.path("/employee/**").uri("lb://Employee"))
				.build();
	}
	
//	//added this code on 18th May25 but still not working of token authentication
//	@Bean
//    public GlobalFilter authenticationFilter() {
//        return (exchange, chain) -> {
//            String token = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
//            if (token != null) {
//                exchange.getRequest().mutate().header(HttpHeaders.AUTHORIZATION, token);
//            }
//            return chain.filter(exchange);
//        };
//    }
//	
//	//added this code on 18th May25 but still not working of token authentication
//	@Bean
//	public GlobalFilter loggingFilter() {
//	    return (exchange, chain) -> {
//	        System.out.println("Incoming request: " + exchange.getRequest().getURI());
//	        return chain.filter(exchange);
//	    };
//	}

	
//	@Bean
//	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
//		if(frontend.isEmpty() || api.isEmpty()) {
//			throw new IllegalArgumentException("");
//		}
//		
//		return builder.routes()
//				.route("angular" ,r -> r.path("/**").uri(frontend))
//				
//				.route("api" ,r -> r.path("/room/**").uri(api))
//				.build();
//	}
	
//	@Bean
//	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route(r -> r.path("/employee/showCreateEmployee")
//				.uri("http://localhost:8880/")
//				)
//				
//				.route(r -> r.path("/room/**")
//						.uri("http://localhost:8882/")
//						)
//				.build();
//	}
	
	
//	We configured in application.yml, so below code is not required
//	@Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//        	@Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
////                        .allowedOrigins("http://localhost:4200")
//                        .allowedOrigins("*")
//                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
//                        .allowedHeaders("*");
//            }
//        };
//    }
	
//	@Bean
//	public CorsFilter corsFilter() {
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		CorsConfiguration config = new CorsConfiguration();
//		config.setAllowCredentials(true);
//		config.addAllowedOrigin("*");
//		config.addAllowedHeader("*");
//		config.addAllowedMethod("*");
//		source.registerCorsConfiguration("/**", config);
//		return new CorsFilter(source);
//	}
}
