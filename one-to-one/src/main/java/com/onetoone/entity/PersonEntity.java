package com.onetoone.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "person1to1")
@Data
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "first_name")
    private String firstName ;

    @Column(name = "last_name")
    private String lastName ;

    @OneToOne()
    @JoinColumn(name = "address_id")
    private AddressEntity address;

}
