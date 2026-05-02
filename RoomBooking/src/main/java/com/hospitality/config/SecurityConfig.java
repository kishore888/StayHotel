package com.hospitality.config;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;



//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.server.SecurityWebFilterChain;

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//added this code on 18th May25 but still not working of token authentication
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/dashboard/**").permitAll()
//                .anyRequest().authenticated()
//            )
//            .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
//        return http.build();
//    }
    
//    @Bean
//    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
//        http.oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
//        http.authorizeExchange()
//            .pathMatchers("/api/**").authenticated()
//            .anyExchange().permitAll();
//        return http.build();
//    }
//}


//@Configuration
//@EnableWebFluxSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
//        http.oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
//        http.authorizeExchange()
//            .pathMatchers("/api/**").authenticated()
//            .anyExchange().permitAll();
//        return http.build();
//    }
//
//    @Bean
//    @Primary
//    public ServerHttpSecurity serverHttpSecurity() {
//        return ServerHttpSecurity.http();
//    }
//}

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//	@Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .cors().and()
//            .csrf().disable()
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/room/**").permitAll()
//                .anyRequest().authenticated()
//            )
//            .formLogin()
//            .and()
//            .httpBasic();
//
//        return http.build();
//    }
	
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(auth -> auth
//                .requestMatchers("/room/**").hasRole("admin")
//                .requestMatchers("/user/**").hasRole("USER")
//                .anyRequest().authenticated())
//            .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwtConfigurer -> 
//                jwtConfigurer.jwtAuthenticationConverter(jwtAuthenticationConverter())));
//
//        return http.build();
//    }
//
//    @Bean
//    public JwtAuthenticationConverter jwtAuthenticationConverter() {
//        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
//        converter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());
//        return converter;
//    }
}


