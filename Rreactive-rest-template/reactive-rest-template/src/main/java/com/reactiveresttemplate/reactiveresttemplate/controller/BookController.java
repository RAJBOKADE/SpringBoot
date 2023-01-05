package com.reactiveresttemplate.reactiveresttemplate.controller;

import com.reactiveresttemplate.reactiveresttemplate.model.Book;
import com.reactiveresttemplate.reactiveresttemplate.service.BookService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Log4j2
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(path = "/books/{id}")
    public Mono<Book> getBooks(@PathVariable Long id){
        log.info("GET - REST TEMPLATE CONTROLLER");
        return bookService.getBooks(id);
    }

    @GetMapping(path = "/books")
    public Flux<Book> getAllBooks(){
        log.info("GET - REST TEMPLATE CONTROLLER");
        return bookService.getAllBooks();
    }
}
