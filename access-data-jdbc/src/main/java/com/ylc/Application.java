package com.ylc;

import com.ylc.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author: tree
 * version: 1.0
 * date: 2017/12/26 14:12
 * description: xxx
 * own: Aratek
 */
@SpringBootApplication
public class Application {

    private static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(JdbcTemplate jdbcTemplate) {
        return (args) -> {
            log.info("1.Creating tables");
            jdbcTemplate.execute("DROP TABLE customer IF EXISTS ");
            jdbcTemplate.execute("CREATE TABLE customer(id SERIAL,first_name VARCHAR(255),last_name VARCHAR(255)) ");
            List<Object[]> splitUpNames = Arrays.asList("李 四","张 三","王 五","John Woo").stream().map(name -> name.split(" ")).collect(Collectors.toList());
            splitUpNames.forEach(name -> log.info("Inserting customer record for %s %s",name[0],name[1]));
            jdbcTemplate.batchUpdate("insert into customer(first_name,last_name) values(?,?)", splitUpNames);
            log.info("查询姓张的人");
            jdbcTemplate.query("SELECT id, first_name, last_name FROM customer WHERE first_name = ?", new Object[] { "Josh" },(rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))).forEach(customer -> log.info(customer.toString()));
        };
    }
}
