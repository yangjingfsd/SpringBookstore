package com.ylab.springbookstore;

import java.util.List;

public interface BookServiceInterface {
    List<Book> findAll();
    Book findById(int theId);
    void save(Book theBook);
    void deleteById(int theId);
}
