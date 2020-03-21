package com.axisx.xgateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@Slf4j
public class AccessFilter implements GlobalFilter {

    private AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String accessToken = getToken(exchange.getRequest());

        log.info("检查TOKEN");
        // 获取用户信息（安全认证时feign调用）
        if(pathMatcher.match("/user/detail/**",exchange.getRequest().getPath().value())){
            return chain.filter(exchange);
        }
        // springbootAdmin 检查
        if(pathMatcher.match("/actuator/**",exchange.getRequest().getPath().value())){
            return chain.filter(exchange);
        }

        if(!pathMatcher.match("/oauth/token",exchange.getRequest().getPath().value())){
            if(accessToken==null){
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }
        }

        return chain.filter(exchange);
    }

    private String getToken(ServerHttpRequest request) {
        List<String> authorization = request.getHeaders().get("Authorization");
        String authToken = null;
        if (authorization != null) {
            authToken = authorization.get(0).substring("Bearer".length()).trim();
        }
/*        if (StringUtils.isBlank(authToken)) {
            strings = request.getQueryParams().get("access_token");
            if (strings != null) {
                authToken = strings.get(0);
            }
        }*/
        return authToken;
    }
}
