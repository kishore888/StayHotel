package com.hospitality.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.OAuth2ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.jwt.JwtDecoder;
//import org.springframework.security.oauth2.jwt.NimbusJwtDecoderJwkSupport;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends OAuth2ResourceServerConfigurerAdapter {
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests(authorizeRequests ->
//                authorizeRequests
//                    .requestMatchers("/auth/**").permitAll()
//                    .anyRequest().authenticated()
//            );
//    }
//
//    @Bean
//    public JwtDecoder jwtDecoder() {
//        return NimbusJwtDecoderJwkSupport.withJwkSetUri("https://example.com/.well-known/jwks.json").build();
//    }
//}
//
//
//


//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AbstractAuthenticationToken;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.oauth2.jwt.Jwt;
//import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
//import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//
//import reactor.core.publisher.Mono;
//
//@Configuration
//@EnableWebFluxSecurity
//public class SecurityConfig {
//  @Bean
//  SecurityWebFilterChain filterChain(ServerHttpSecurity httpSecurity) throws Exception {
//    httpSecurity.authorizeExchange((exchanges) -> exchanges
////                .pathMatchers(HttpMethod.POST, "/customer").hasRole("admin")
////                .pathMatchers("/account/**").authenticated()
//                .pathMatchers(HttpMethod.POST, "/room").hasRole("admin")
//                .pathMatchers("/room/**").authenticated()
//        .pathMatchers("/customer/**").authenticated())
//        .oauth2ResourceServer(oAuth2 -> oAuth2
//                        .jwt(jwtSpec -> jwtSpec.jwtAuthenticationConverter(grantedAuthoritiesExtractor())));
//    httpSecurity.csrf(ServerHttpSecurity.CsrfSpec::disable);
//    
//    return httpSecurity.build();
//    
//  }
//  
//    private Converter<Jwt, Mono<AbstractAuthenticationToken>> grantedAuthoritiesExtractor() {
//        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
//        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new AuthServerRoleConverter());
//        return new ReactiveJwtAuthenticationConverterAdapter(jwtAuthenticationConverter);
//    }
//}

//below code should be
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http.oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
        http.authorizeExchange()
            .pathMatchers("/dashbord/**").authenticated()
            .anyExchange().permitAll();
        return http.build();
    }
}


