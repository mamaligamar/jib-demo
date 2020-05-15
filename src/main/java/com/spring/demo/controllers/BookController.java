package com.spring.demo.controllers;

import com.spring.demo.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String listBooks(Model model){
        model.addAttribute("books", bookService.findAll());
        return "index";
    }

}
