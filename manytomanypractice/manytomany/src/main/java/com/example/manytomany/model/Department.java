package com.example.manytomany.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.Set;

@Data
@Log4j2
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    private String deptName;
    private Set<Employee>employee;
}
