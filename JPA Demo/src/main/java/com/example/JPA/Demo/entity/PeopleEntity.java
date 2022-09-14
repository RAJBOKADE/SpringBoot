package com.example.JPA.Demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "people")
public class PeopleEntity {
    @Id
    private Long id;
    @Column (name = "first_Name")
    private String firstName;
    @Column (name = "last_Name")
    private String lastName;
}
