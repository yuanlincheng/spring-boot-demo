package com.ylc;

import com.ylc.model.vo.StorageProperties;
import com.ylc.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author: tree
 * @version: 1.0
 * date: 2017/12/26 23:17
 * @description: xxx
 * own: Aratek
 */
@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class UploadFileApplication {
    public static void main(String[] args) {
        SpringApplication.run(UploadFileApplication.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}
