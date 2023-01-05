package com.reactivebook.com.reactivebook.mapper;

import com.reactivebook.com.reactivebook.entity.BookEntity;
import com.reactivebook.com.reactivebook.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookEntity modelToEntity(Book book);
    Book entityToModel(BookEntity bookEntity);
}
