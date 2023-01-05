package com.reactivebook.com.reactivebook.repository;

import com.reactivebook.com.reactivebook.entity.BookEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends ReactiveCrudRepository<BookEntity, Long> {
}
