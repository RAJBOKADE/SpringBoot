package com.onetoone.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "address1to1")
@Data

public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id ;

    private String address1 ;

    private String address2 ;

    private String state ;

    private String city ;

    @OneToOne(mappedBy = "address1to1")
    private PersonEntity person ;
}
