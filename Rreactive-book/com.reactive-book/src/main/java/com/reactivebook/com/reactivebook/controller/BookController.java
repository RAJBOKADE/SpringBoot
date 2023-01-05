package com.reactivebook.com.reactivebook.controller;

import com.reactivebook.com.reactivebook.entity.BookEntity;
import com.reactivebook.com.reactivebook.model.Book;
import com.reactivebook.com.reactivebook.service.BookService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Log4j2
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(path = "/addbooks")
    public Mono<BookEntity> saveBook(@RequestBody Book book){
        log.info("POST- Book controller found");
        return bookService.addBooks(book);
    }

    @GetMapping(path = "/books/{id}")
    public Mono<BookEntity> getBooks(@PathVariable Long id){
        log.info("GET - Book controller found");
        return bookService.getBook(id);
    }

    @GetMapping(path = "/books")
    public Flux<BookEntity> allBooks(){
        log.info("GET - all Book controller found");
        return bookService.allBooks();
    }

    @PutMapping(path = "/book/{id}")
    public Mono<BookEntity> updateBook(@PathVariable Long id, @RequestBody Book book){
        log.info("PUT - Book controller found");
        return bookService.updateBook(id, book);
    }

    @DeleteMapping(path = "/book/{id}")
    public Mono<Void> deleteBook(@PathVariable Long id){
        log.info("DELETE - Book controller found");
        return bookService.deleteBook(id);
    }
}

