package com.example.JPA.Demo.mapper;

import com.example.JPA.Demo.entity.PeopleEntity;
import com.example.JPA.Demo.model.People;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")

public interface PeopleMapper {

    PeopleEntity peopleToEntity (People people);
    People entityToPeople (PeopleEntity peopleEntity);
}
