package com.ylc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: tree
 * @version: 1.0
 * date: 2018/1/1 9:36
 * @description: xxx
 * own: Aratek
 */
@SpringBootApplication  //@SpringBootApplication = @Configuration + @ComponentScan + @EnableAutoConfiration
public class StaticResourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(StaticResourceApplication.class, args);
    }
}
