package com.ylab.springbookstore;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class BookServiceInterfaceImpl implements BookServiceInterface{

    private BookRepository bookRepository;

    public BookServiceInterfaceImpl(BookRepository theBookRepository){
        this.bookRepository = theBookRepository;
    }

    @Override
    public List<Book> findAll(){
        return bookRepository.findAllByOrderByAuthorAsc();
    }
    
    @Override
    public Book findById(int theId){
        Optional<Book> result = bookRepository.findById(theId);

        Book theBook = null;

        if(result.isPresent()){
            theBook = result.get();
        } else {
            throw new RuntimeException("Book with ID " + theId + "not found!");
        }

        return theBook;
    }

    @Override
    public void save(Book theBook){
        bookRepository.save(theBook);
    }

    @Override
    public void deleteById(int theId){
        bookRepository.deleteById(theId);
    } 
}