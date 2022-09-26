package com.onetoone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequest extends PersonResponse {

    private String firstName ;

    private String lastName ;

    private AddressRequest address ;
}
