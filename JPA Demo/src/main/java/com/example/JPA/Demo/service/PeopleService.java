package com.example.JPA.Demo.service;

import com.example.JPA.Demo.entity.PeopleEntity;
import com.example.JPA.Demo.model.People;
import com.example.JPA.Demo.model.PeopleResponse;
import com.example.JPA.Demo.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;
   /* @Autowired
    private final PeopleMapper peopleMapper;
*/
    /*public PeopleService(PeopleRepository personRepository, PeopleMapper peopleMapper){
        this.peopleRepository = personRepository;
        this.peopleMapper = peopleMapper;
        PeopleEntity peopleEntity = peopleMapper.toEntity(new People());
    }*/

    /*public PeopleEntity savePeople (PeopleEntity people){
        return peopleRepository.save(people);
    }

    public List<PeopleEntity> savePersons(List<PeopleEntity> persons){
        return peopleRepository.saveAll(persons);
    }
    public List<PeopleEntity> getPerson(){
        return peopleRepository.findAll();
    }

    public PeopleEntity getPersonById(Long id){
        return peopleRepository.findById(id).orElse(null);
    }*/

    /*public PeopleEntity updateProduct(PeopleEntity peopleEntity){
        PeopleEntity exisiting= peopleRepository.findById(peopleEntity.getId()).orElse(null);
        exisiting.setFirstName(peopleEntity.getFirstName());
        exisiting.setLastName(peopleEntity.getLastName());
        return peopleRepository.save(exisiting);
    }*/

   /* public String deletePeople(Long id){
        peopleRepository.deleteById(id);
        return "People Deleted"+id;
    }*/

    public PeopleResponse createPeople (People people){
        PeopleEntity peopleEntity = new PeopleEntity();
        peopleEntity.setFirstName(people.getFirstName());
        peopleEntity.setLastName(people.getLastName());
        Long id = (long) (Math.random()*20);
        peopleEntity.setId(id);
        PeopleResponse peopleResponse = new PeopleResponse();
        peopleResponse.setId(peopleEntity.getId());
        peopleRepository.save(peopleEntity);
        return peopleResponse;
    }

}
