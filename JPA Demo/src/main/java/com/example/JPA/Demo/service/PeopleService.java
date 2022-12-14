package com.example.JPA.Demo.service;

import com.example.JPA.Demo.entity.PeopleEntity;
import com.example.JPA.Demo.mapper.PeopleMapper;
import com.example.JPA.Demo.model.People;
import com.example.JPA.Demo.model.PeopleResponse;
import com.example.JPA.Demo.repository.PeopleRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j2
@Service
public class PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;
    @Autowired
    private PeopleMapper peopleMapper;


    //Traditional Method of create/save people
    public PeopleResponse createPeople(People people) {
        PeopleEntity peopleEntity = new PeopleEntity();
        peopleEntity.setFirstName(people.getFirstName());
        peopleEntity.setLastName(people.getLastName());
        Long id = (long) (Math.random() * 20);
        peopleEntity.setId(id);
        PeopleResponse peopleResponse = new PeopleResponse();
        peopleResponse.setId(peopleEntity.getId());
        peopleRepository.save(peopleEntity);
        return peopleResponse;
    }


    //Mapper Method of save/create people
    public PeopleResponse save(People people) {
        PeopleEntity peopleEntity = new PeopleEntity();
        peopleEntity = peopleMapper.peopleToEntity(people);
        PeopleResponse peopleResponse = new PeopleResponse();
        Long id = (long) (Math.random() * 20);
        peopleEntity.setId(id);
        peopleResponse.setId(peopleEntity.getId());
        peopleRepository.save(peopleEntity);
        return peopleResponse;
    }


    //Get Method Mapper
    public People getPeople(Long peopleId) {
        People people = new People();
        Optional<PeopleEntity> peopleEntityOptional = peopleRepository.findById(peopleId);
        if (peopleEntityOptional.isPresent()) {
            people = peopleMapper.entityToPeople(peopleEntityOptional.get());
        } else {
            log.info("People id" + peopleId + "Not Found");

        }
        return people;
    }


    public void updatePeople(Long peopleid, People people) {
        PeopleEntity peopleEntity = new PeopleEntity();
        Optional<PeopleEntity> peopleEntityOptional = peopleRepository.findById(peopleid);
        if (peopleEntityOptional.isPresent()) {
            peopleEntityOptional.get().setFirstName(people.getFirstName());
            peopleEntityOptional.get().setLastName(people.getLastName());
            peopleRepository.save(peopleEntityOptional.get());

        }
        else {
            log.info("People Id" + peopleid + "Not Found");
        }

        //return people;
    }

   /* public People updatePeople(Long peopleid, People people){
        Optional<PeopleEntity> peopleEntity = peopleRepository.findById(peopleid);
        if(peopleEntity.isPresent()){
            peopleEntity = peopleMapper.peopleToEntity();
            peopleRepository.save(peopleEntity.get());
        }
        else {
            log.info("People Id" +peopleid + "Not Found");
        }
        return people;
    }*/

    public void deletePeople(Long peopleId) {
        peopleRepository.deleteById(peopleId);
    }
}
