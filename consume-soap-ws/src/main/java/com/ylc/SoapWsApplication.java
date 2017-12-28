package com.ylc;

import com.ylc.wsdl.GetQuoteResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * author: tree
 * version: 1.0
 * date: 2017/12/28 11:30
 * description: xxx
 * own: Aratek
 */
@SpringBootApplication
public class SoapWsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SoapWsApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(QuoteClient quoteClient) {
        return (args) -> {
            String ticker = "MSFT";

            if (args.length > 0) {
                ticker = args[0];
            }
            GetQuoteResponse response = quoteClient.getQuote(ticker);
            System.err.println(response.getGetQuoteResult());
        };
    }
}
