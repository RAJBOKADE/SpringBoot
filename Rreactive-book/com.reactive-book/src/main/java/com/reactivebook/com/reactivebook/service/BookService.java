package com.reactivebook.com.reactivebook.service;

import com.reactivebook.com.reactivebook.entity.BookEntity;
import com.reactivebook.com.reactivebook.mapper.BookMapper;
import com.reactivebook.com.reactivebook.model.Book;
import com.reactivebook.com.reactivebook.repository.BookRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Log4j2
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    public Mono<BookEntity> addBooks(Book book) {
        log.info("ADD BOOKS - Book Saved in database");
        BookEntity bookEntity = bookMapper.modelToEntity(book);
        return bookRepository.save(bookEntity);
    }

    public Mono<BookEntity> getBook(Long id) {
        log.info("GET BOOK - GETTING BOOK");
        return bookRepository.findById(id);
    }

    public Flux<BookEntity> allBooks() {
        log.info("GET BOOK - GETTING BOOK");
        return bookRepository.findAll();
    }

    public Mono<BookEntity> updateBook(Long id, Book book) {
        log.info("UPDATE BOOK - UPDATING BOOK");
        BookEntity bookEntity=new BookEntity();
        bookEntity.setTitle(book.getTitle());
        bookEntity.setAuthor(book.getAuthor());
        return bookRepository.save(bookEntity);
    }

    public Mono<Void> deleteBook(Long id) {
        log.info("GET BOOK - DELETE BOOK");
        return bookRepository.deleteById(id);
    }


}
