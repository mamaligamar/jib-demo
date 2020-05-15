package com.spring.demo.services;

import com.spring.demo.model.Book;
import com.spring.demo.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(book -> books.add(book));
        return books;
    }
}
