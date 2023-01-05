package com.reactiveresttemplate.reactiveresttemplate.service;

import com.reactiveresttemplate.reactiveresttemplate.model.Book;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@Log4j2
public class BookService {

    @Value("${base.url}")
    private String baseurl;

    @Value("${get.url}")
    private String getBaseurl;

    @Value("${getAll.url}")
    private String getAllUrl;


    private final WebClient webClient;

    public BookService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(baseurl).build();
    }


    public Mono<Book> getBooks(Long id) {
        return this.webClient.get().uri(baseurl +"/books/{id}", id)
                .retrieve().bodyToMono(Book.class);
    }

    public Flux<Book> getAllBooks() {
        return this.webClient.get().uri(baseurl +"/books")
                .retrieve().bodyToFlux(Book.class);
    }
}
