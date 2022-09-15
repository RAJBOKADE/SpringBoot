package com.example.JPA.Demo.controller;

import com.example.JPA.Demo.entity.PeopleEntity;
import com.example.JPA.Demo.model.People;
import com.example.JPA.Demo.model.PeopleResponse;
import com.example.JPA.Demo.repository.PeopleRepository;
import com.example.JPA.Demo.service.PeopleService;
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
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Log4j2
@RestController
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @PostMapping(path = "/peoples", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    //Traditiopnal Method
       /* public ResponseEntity<PeopleResponse> createPeople(@RequestBody People people){
        PeopleResponse peopleResponse = peopleService.createPeople(people);
        return new ResponseEntity<>(peopleResponse, HttpStatus.OK);
    }*/

    //Mapper
    public ResponseEntity<PeopleResponse> save(@RequestBody People people){
        PeopleResponse peopleResponse=peopleService.save(people);
        return new ResponseEntity<>(peopleResponse,HttpStatus.OK);
    }


  /*  @GetMapping(path = "/peoples/{peopleId}", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<People> getPerson (@PathVariable Long peopleId){
        PeopleResponse peopleResponse = peopleService.getPeople(peopleId);
        if(Objects.isNull(peopleId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }*/

    @GetMapping(path = "/peoples/{peopleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<People> getPerson (@PathVariable Long peopleId){
        People people = peopleService.getPeople(peopleId);
        if (Objects.isNull(people)){
            log.info("People id"+peopleId+"found");
            //log.info(people.getFirstName());
        }
        else {
            ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @PutMapping(path = "/peoples/{peopleId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<People> updatePeople (@PathVariable Long peopleId, @RequestBody People people){
        peopleService.updatePeople(peopleId, people);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/peoples/{peopleId}")
    public ResponseEntity<People> deletePeople(@PathVariable Long peopleId){
        peopleService.deletePeople(peopleId);
        return ResponseEntity.ok().build();
    }
}
