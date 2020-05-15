package com.spring.demo.bootstrap;

import com.spring.demo.model.Author;
import com.spring.demo.model.Book;
import com.spring.demo.model.Publisher;
import com.spring.demo.repositories.AuthorRepository;
import com.spring.demo.repositories.BookRepository;
import com.spring.demo.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DemoData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public DemoData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher = new Publisher();
        publisher.setName("EVANS");
        publisher.setCity("New York");
        publisherRepository.save(publisher);

        Author authorDDD = new Author();
        authorDDD.setName("Eric");
        authorDDD.setSurname("Evans");

        Book book = new Book();
        book.setTitle("Domain driven design");
        book.setIsbn("123123");

        List<Book> publisherBooks = new ArrayList<>();

        List<Book> books = new ArrayList<>();
        books.add(book);

        List<Author> authors = new ArrayList<>();
        authors.add(authorDDD);

        authorDDD.setBooks(books);
        book.setAuthors(authors);
        book.setPublisher(publisher);

        authorRepository.save(authorDDD);
        bookRepository.save(book);
        publisherRepository.save(publisher);

        Author authorJava = new Author();
        authorJava.setName("Joshua");
        authorJava.setSurname("Bloch");

        Book bookJava = new Book();
        bookJava.setTitle("Effective Java");
        bookJava.setIsbn("3939459469");

        List<Book> javaBooks = new ArrayList<>();
        javaBooks.add(bookJava);
        authorJava.setBooks(javaBooks);

        List<Author> authorsJava = new ArrayList<>();
        authorsJava.add(authorJava);
        bookJava.setAuthors(authorsJava);
        bookJava.setPublisher(publisher);

        publisherBooks.addAll(javaBooks);
        publisherBooks.addAll(books);
        publisher.setBooks(publisherBooks);

        authorRepository.save(authorJava);
        bookRepository.save(bookJava);
        publisherRepository.save(publisher);

    }
}
