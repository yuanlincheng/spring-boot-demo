package com.ylc;

import com.ylc.receive.Receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.concurrent.CountDownLatch;

/**
 * author: tree
 * version: 1.0
 * date: 2017/12/27 11:21
 * description: xxx
 * own: Aratek
 */
@SpringBootApplication
public class MsgRedisApplication {

    private static Logger log = LoggerFactory.getLogger(MsgRedisApplication.class);

    @Bean
    RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory, MessageListenerAdapter messageListenerAdapter) {
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
        redisMessageListenerContainer.addMessageListener(messageListenerAdapter,new PatternTopic("chat"));
        return redisMessageListenerContainer;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

    @Bean
    Receiver receiver(CountDownLatch countDownLatch) {
        return new Receiver(countDownLatch);
    }

    //@Bean明确地指示了一种方法，什么方法呢——产生一个bean的方法，并且交给Spring容器管理
    @Bean
    CountDownLatch countDownLatch() {
        return new CountDownLatch(1);
    }

    @Bean
    StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        return new StringRedisTemplate(redisConnectionFactory);
    }

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = SpringApplication.run(MsgRedisApplication.class, args);
        StringRedisTemplate stringRedisTemplate = ctx.getBean(StringRedisTemplate.class);
        CountDownLatch countDownLatch = ctx.getBean(CountDownLatch.class);
        log.info("send Message");
        stringRedisTemplate.convertAndSend("chat","Hello from Redis!");
        countDownLatch.await();
        System.exit(0);
    }
}
