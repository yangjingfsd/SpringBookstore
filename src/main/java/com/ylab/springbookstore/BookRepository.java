package com.ylab.springbookstore;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

    public List<Book> findAllByOrderByAuthorAsc();
    
}
