package com.example.JPA.Demo.repository;

import com.example.JPA.Demo.entity.PeopleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository  extends JpaRepository<PeopleEntity, Long> {


}
