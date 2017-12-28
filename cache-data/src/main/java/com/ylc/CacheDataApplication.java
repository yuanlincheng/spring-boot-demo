package com.ylc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * author: tree
 * version: 1.0
 * date: 2017/12/28 14:17
 * description: xxx
 * own: Aratek
 */
@SpringBootApplication
@EnableCaching
public class CacheDataApplication {
    public static void main(String[] args) {
        SpringApplication.run(CacheDataApplication.class, args);
    }
}
