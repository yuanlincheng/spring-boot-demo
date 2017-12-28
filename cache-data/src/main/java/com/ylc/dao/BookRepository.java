package com.ylc.dao;

import com.ylc.model.Book;

/**
 * author: tree
 * version: 1.0
 * date: 2017/12/28 14:20
 * description: xxx
 * own: Aratek
 */
public interface BookRepository {
    Book getByIsbn(String isbn);
}
