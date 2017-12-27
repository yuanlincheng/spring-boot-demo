package com.ylc;

import com.ylc.model.User;
import com.ylc.service.GitHubLookupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

/**
 * @author: tree
 * @version: 1.0
 * date: 2017/12/27 23:03
 * @description: xxx
 * own: Aratek
 */
@SpringBootApplication
@EnableAsync
public class AsyncMethodApplication {

    private static final Logger log = LoggerFactory.getLogger(AsyncMethodApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AsyncMethodApplication.class, args);
    }

    @Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("GithubLookup-");
        executor.initialize();
        return executor;
    }

    @Bean
    CommandLineRunner init(GitHubLookupService gitHubLookupService) {
        return (args) ->{
            // Start the clock
            long start = System.currentTimeMillis();

            // Kick of multiple, asynchronous lookups
            CompletableFuture<User> page1 = gitHubLookupService.findUser("PivotalSoftware");
            CompletableFuture<User> page2 = gitHubLookupService.findUser("CloudFoundry");
            CompletableFuture<User> page3 = gitHubLookupService.findUser("Spring-Projects");

            // Wait until they are all done
            CompletableFuture.allOf(page1,page2,page3).join();

            // Print results, including elapsed time
            log.info("Elapsed time: " + (System.currentTimeMillis() - start));
            log.info("--> " + page1.get());
            log.info("--> " + page2.get());
            log.info("--> " + page3.get());
        };
    }
}
