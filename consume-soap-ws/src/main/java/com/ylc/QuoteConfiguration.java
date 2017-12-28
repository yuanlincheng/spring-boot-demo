package com.ylc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * author: tree
 * version: 1.0
 * date: 2017/12/28 14:05
 * description: xxx
 * own: Aratek
 */
@Configuration   //用@Configuration注解该类，等价 与XML中配置beans；
public class QuoteConfiguration {
    @Bean   //用@Bean标注方法等价于XML中配置bean。
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.ylc.wsdl");
        return marshaller;
    }

    @Bean
    public QuoteClient quoteClient(Jaxb2Marshaller marshaller) {
        QuoteClient client = new QuoteClient();
        client.setDefaultUri("http://www.webservicex.com/stockquote.asmx");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
