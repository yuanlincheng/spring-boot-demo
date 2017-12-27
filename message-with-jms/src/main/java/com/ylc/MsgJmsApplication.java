package com.ylc;

import com.ylc.model.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;

/**
 * author: tree
 * version: 1.0
 * date: 2017/12/27 17:28
 * description: xxx
 * own: Aratek
 */
@SpringBootApplication
@EnableJms
public class MsgJmsApplication {

    private static Logger log = LoggerFactory.getLogger(MsgJmsApplication.class);

    @Bean
    public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory,connectionFactory);
        return factory;
    }

    @Bean // Serialize message content to json using TextMessage
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =  SpringApplication.run(MsgJmsApplication.class, args);
        JmsTemplate jmsTemplate = ctx.getBean(JmsTemplate.class);
        log.info("发送一个邮件消息");
        jmsTemplate.convertAndSend("mailbox",new Email("abc","sdfsdfsdfsdf"));
    }
}
