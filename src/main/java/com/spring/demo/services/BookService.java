package com.spring.demo.services;

import com.spring.demo.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
}
