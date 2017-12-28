package com.ylc.dao.impl;

import com.ylc.dao.BookRepository;
import com.ylc.model.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * author: tree
 * version: 1.0
 * date: 2017/12/28 14:41
 * description: xxx
 * own: Aratek
 */
@Component
public class SimpleBookRepository implements BookRepository {
    @Override
    @Cacheable("books")
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        return new Book(isbn,"Some book");
    }

    private void simulateSlowService() {
        long Time = 3000;
        try {
            Thread.sleep(Time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
