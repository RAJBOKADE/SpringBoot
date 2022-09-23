package com.example.OneToOne.controller;

import com.example.OneToOne.model.Person;
import com.example.OneToOne.model.PersonResponse;
import com.example.OneToOne.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping(path = "/persons", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonResponse> createPerson (@RequestBody Person person){
    PersonResponse personResponse=personService.createPerson(person);
    return new ResponseEntity<>(personResponse, HttpStatus.OK);
    }



}
