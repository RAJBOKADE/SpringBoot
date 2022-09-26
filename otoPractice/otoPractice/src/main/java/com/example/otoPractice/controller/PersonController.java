package com.example.otoPractice.controller;

import com.example.otoPractice.model.Person;
import com.example.otoPractice.model.PersonResponse;
import com.example.otoPractice.service.PersonAddressService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class PersonController {

    @Autowired
    private PersonAddressService personAddressService;

    @PostMapping(path = "/persons", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonResponse> createPerson (@RequestBody Person person){
        PersonResponse personResponse = personAddressService.createPerson (person);
        log.info("Posted successfully");
        return  new ResponseEntity<>(personResponse, HttpStatus.OK);
    }

    @GetMapping(path = "/persons/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> getPersonById (@PathVariable Long personId){
        Person person = personAddressService.getPersonById (personId);
        log.info("Person Found");
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PutMapping(path = "/persons/{personId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> updatePerson (@RequestBody Person person, @PathVariable Long personId){
        person = personAddressService.updatePerson(personId, person);
        log.info("Updated Successfully");
        return new ResponseEntity<>(person, HttpStatus.OK);

    }

    @DeleteMapping(path = "/persons/{personId}")
    public ResponseEntity<Void> deletePerson (@PathVariable Long personId){
        personAddressService.deletePerson (personId);
        return ResponseEntity.ok().build();
    }
}
