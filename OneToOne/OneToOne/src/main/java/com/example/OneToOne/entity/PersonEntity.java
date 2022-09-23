package com.example.OneToOne.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
@Data
public class PersonEntity {
    @Id
    private Long id;
    @Column(name = "first_Name")
    private String firstName;
    @Column(name = "last_Name")
    private String lastName;

    @OneToOne
    @JoinColumn(name = "address_Id")
    private AddressEntity address;

}
