package com.hospitality;

import org.apache.http.HttpHeaders;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class FirstPreLastPostGlobalFilter implements GlobalFilter, Ordered {

//    final Logger logger =
//      LoggerFactory.getLogger(FirstPreLastPostGlobalFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange,
      GatewayFilterChain chain) {
//        logger.info("First Pre Global Filter");
    	System.out.println("API GATEWAY - FirstPreLastPostGlobalFilter");
        return chain.filter(exchange)
          .then(Mono.fromRunnable(() -> {
//              logger.info("Last Post Global Filter");
            }));
    }

    @Override
    public int getOrder() {
        return -1;
    }
    
    


}
