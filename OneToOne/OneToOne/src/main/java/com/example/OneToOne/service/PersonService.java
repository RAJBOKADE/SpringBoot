package com.example.OneToOne.service;

import com.example.OneToOne.entity.AddressEntity;
import com.example.OneToOne.entity.PersonEntity;
import com.example.OneToOne.model.Person;
import com.example.OneToOne.model.PersonResponse;
import com.example.OneToOne.repository.AddressRepository;
import com.example.OneToOne.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private  PersonRepository personRepository;
    @Autowired
    private  AddressRepository addressRepository;


    public PersonResponse createPerson(Person person) {
        PersonEntity personEntity=new PersonEntity();
       AddressEntity addressEntity=new AddressEntity();
        PersonResponse pResponse = new PersonResponse();
        addressEntity.setAddress1(person.getAddress().getAddress1());
        addressEntity.setAddress2(person.getAddress().getAddress2());
        addressEntity.setCity(person.getAddress().getCity());
        addressEntity.setState(person.getAddress().getState());
        addressEntity.setZipCode(person.getAddress().getZipcode());
        addressRepository.save(addressEntity);
        personEntity.setFirstName(person.getFirstName());
        personEntity.setLastName(person.getLastName());
        personEntity.setAddressEntity(addressEntity);
        personRepository.save(personEntity);
        pResponse.setPersonId(personEntity.getId());
        return pResponse;
    }


}
