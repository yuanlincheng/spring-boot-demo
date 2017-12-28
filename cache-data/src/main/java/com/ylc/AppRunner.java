package com.ylc;

import com.ylc.dao.BookRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * author: tree
 * version: 1.0
 * date: 2017/12/28 14:44
 * description: xxx
 * own: Aratek
 */
@Component
@AllArgsConstructor
public class AppRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(AppRunner.class);

    public final BookRepository bookRepository;

    @Override
    public void run(String... strings) throws Exception {
        log.info("......开始查找书籍");
        log.info("isbn-1234" + bookRepository.getByIsbn("isbn-1234"));
        log.info("isbn-4567" + bookRepository.getByIsbn("isbn-4567"));
        log.info("isbn-1234" + bookRepository.getByIsbn("isbn-1234"));
        log.info("isbn-4567" + bookRepository.getByIsbn("isbn-4567"));
        log.info("isbn-1234" + bookRepository.getByIsbn("isbn-1234"));
        log.info("isbn-1234" + bookRepository.getByIsbn("isbn-1234"));
    }
}
