package com.example.otoPractice.service;

import com.example.otoPractice.entity.AddressEntity;
import com.example.otoPractice.entity.PersonEntity;
import com.example.otoPractice.model.Address;
import com.example.otoPractice.model.Person;
import com.example.otoPractice.model.PersonResponse;
import com.example.otoPractice.repository.PersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class PersonAddressService {

    @Autowired
    private PersonRepository personRepository;
    public PersonResponse createPerson(Person person) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setFirstName(person.getFirstName());
        personEntity.setLastName(person.getLastName());

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddress1(person.getAddress().getAddress1());
        addressEntity.setAddress2(person.getAddress().getAddress2());
        addressEntity.setCity(person.getAddress().getCity());
        addressEntity.setZipcode(person.getAddress().getZipcode());

        personEntity.setAddress(addressEntity);
        personRepository.save(personEntity);

        PersonResponse personResponse = new PersonResponse();
        personResponse.setPersonId(personEntity.getPersonId());
        log.info("Post service entered" + personResponse);

        return personResponse;
    }

    public Person getPersonById(Long personId) {

        Optional<PersonEntity> optionalPersonEntity = personRepository.findById(personId);
        Person person = new Person();
        Address address = new Address();

        if (optionalPersonEntity.isPresent()) {
            AddressEntity addressEntity = optionalPersonEntity.get().getAddress();
            PersonEntity personEntity = optionalPersonEntity.get();
            person.setFirstName(personEntity.getFirstName());
            person.setLastName(personEntity.getLastName());

            address.setAddress1(addressEntity.getAddress1());
            address.setAddress2(addressEntity.getAddress2());
            address.setCity(addressEntity.getCity());
            address.setZipcode(addressEntity.getZipcode());

            //To get all details with person model
            person.setAddress(address);
            log.info("Person Id Found");

        }
        else {
            log.info("Person Id Not Found");
        }

        return person;
    }

    public Person updatePerson(Long personId, Person person) {
        Optional<PersonEntity> personEntityOptional = personRepository.findById(personId);

        if (personEntityOptional.isPresent()){
            PersonEntity personEntity = personEntityOptional.get();
            personEntity.setFirstName(person.getFirstName());
            personEntity.setLastName(person.getLastName());

            AddressEntity addressEntity = new AddressEntity();
            addressEntity.setAddress1(person.getAddress().getAddress1());
            addressEntity.setAddress2(person.getAddress().getAddress2());
            addressEntity.setCity(person.getAddress().getCity());
            addressEntity.setZipcode(person.getAddress().getZipcode());
            personEntity.setAddress(addressEntity);

            personRepository.save(personEntity);
            log.info("Updating details....");
        }
        else {
            log.info("Cannot update ID not present");
        }
        return person;

    }

    public void deletePerson(Long personId) {
        personRepository.deleteById(personId);
    }
}
