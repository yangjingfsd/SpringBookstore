package com.ylab.springbookstore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    @NotNull(message = " is required")
    @Size(min = 1, message = " is required")
    private String title;

    @Column(name = "author")
    @NotNull(message = " is required")
    @Size(min = 1, message = " is required")
    private String author;

    @Column(name = "isbn")
    @NotNull(message = " is required")
    @Size(min = 1, message = " is required")
    private String isbn;

    @Column(name = "price")
    @NotNull(message = " is required")
    @Size(min = 1, message = " is required")
    private String price;

    public Book(){}

    public Book(int id, String title, String author, String isbn, String price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
    }

    public Book(String title, String author, String isbn, String price) {
       this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getAuthor(){
        return author;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public String getIsbn(){
        return isbn;
    }

    public void setPrice(String price){
        this.price = price;
    }

    public String getPrice(){
        return price;
    }

}
