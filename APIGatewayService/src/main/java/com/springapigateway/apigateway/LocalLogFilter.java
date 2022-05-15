package com.springapigateway.apigateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component 
public class LocalLogFilter implements GlobalFilter {

	private Logger logUtil = LoggerFactory.getLogger(LocalLogFilter.class); 
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		logUtil.info("Request is being going on for the path -> " + exchange.getRequest().getPath());
		return chain.filter(exchange);
	}

}
