package com.teste.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private final com.teste.demo.BookRepository bookRepository;

    public BookController(com.teste.demo.BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    List<com.teste.demo.Book> getBooks() {
        return bookRepository.findAll();
    }

    @PostMapping
    com.teste.demo.Book createBook(@RequestBody com.teste.demo.Book book) {
        return bookRepository.save(book);
    }

    @GetMapping("/{id}")
    Optional<com.teste.demo.Book> getBookById(@PathVariable("id") Long id) {
        return bookRepository.findById(id);
    }

}
