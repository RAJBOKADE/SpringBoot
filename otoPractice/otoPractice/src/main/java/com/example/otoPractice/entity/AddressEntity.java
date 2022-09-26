package com.example.otoPractice.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "otoaddress")
public class AddressEntity {

    @Id
    @SequenceGenerator(name = "seq_address_id", sequenceName = "seq_address_id", initialValue = 100, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_address_id")
    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "address_1")
    private String address1;

    @Column(name = "address_2")
    private String address2;

    private String city;
   // private String state;
    private String zipcode;

    @OneToOne(mappedBy = "address",cascade = CascadeType.ALL)
    private PersonEntity person;


}
