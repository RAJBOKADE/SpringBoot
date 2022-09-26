package com.example.OneToOne.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address1to1")
@Data
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "address_1")
    private String address1;
    @Column(name = "address_2")
    private String address2;
    private String city;
    private String state;
    private String zipCode;
    @OneToOne(mappedBy = "addressEntity")
    private PersonEntity person;
}
