package com.ylc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * author: tree
 * version: 1.0
 * date: 2017/12/29 14:25
 * description: xxx
 * own: Aratek
 */
@RestController
@SpringBootApplication
public class LoadBaServerApplication {

    private static Logger log = LoggerFactory.getLogger(LoadBaServerApplication.class);

    @GetMapping("/greeting")
    public String greet() {
        log.info("Access greeting");

        List<String> gteetings = Arrays.asList("Hi there", "Greetings", "Salutations");
        Random random = new Random();

        int randomNum = random.nextInt(gteetings.size());
        return gteetings.get(randomNum);
    }

    @GetMapping(value = "/")
    public String home() {
        log.info("Access /");
        return "Hi!";
    }

    public static void main(String[] args) {
        SpringApplication.run(LoadBaServerApplication.class, args);
    }
}
