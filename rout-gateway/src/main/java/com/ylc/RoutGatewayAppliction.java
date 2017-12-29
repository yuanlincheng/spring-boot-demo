package com.ylc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * author: tree
 * version: 1.0
 * date: 2017/12/29 11:39
 * description: xxx
 * own: Aratek
 */
@EnableZuulProxy
@SpringBootApplication
public class RoutGatewayAppliction {

    @Bean
    public SimpleFilter simpleFilter() {
        return new SimpleFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(RoutGatewayAppliction.class, args);
    }
}
