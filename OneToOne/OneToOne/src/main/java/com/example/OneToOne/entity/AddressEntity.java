package com.example.OneToOne.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
@Data
public class AddressEntity {
    @Id
    private Long id;
    @Column(name = "address_1")
    private String address1;
    @Column(name = "address_2")
    private String address2;
    private String city;
    private String state;
    private String zipCode;
    @OneToOne(mappedBy = "address")
    private PersonEntity person;
}
