package com.reactivebook.com.reactivebook.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="bookentity")
public class BookEntity {

    @Id
    private Long id;
    private String title;
    private String author;
}
