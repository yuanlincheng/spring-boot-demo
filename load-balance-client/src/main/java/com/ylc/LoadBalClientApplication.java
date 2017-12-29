package com.ylc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * author: tree
 * version: 1.0
 * date: 2017/12/29 14:32
 * description: xxx
 * own: Aratek
 */
@RestController
@SpringBootApplication
@RibbonClient(name = "load-ba-server", configuration = SayHelloConfiguration.class)
public class LoadBalClientApplication {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String hi(@RequestParam(value="name", defaultValue="Artaban") String name) {
        String greeting = this.restTemplate.getForObject("http://load-ba-server/greeting", String.class);
        return String.format("%s, %s!", greeting, name);
    }

    public static void main(String[] args) {
        SpringApplication.run(LoadBalClientApplication.class, args);
    }
}
