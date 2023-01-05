package com.example.manytomany.service;

import com.example.manytomany.entity.EmployeeEntity;
import com.example.manytomany.mapper.EmployeeMapper;
import com.example.manytomany.model.Employee;
import com.example.manytomany.model.EmployeeResponse;
import com.example.manytomany.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private  EmployeeMapper employeeMapper;
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeResponse createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = null;
        employeeEntity = employeeMapper.modelToEntity(employee);
        employeeRepository.save(employeeEntity);
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setEmpId(employeeEntity.getEmpId());
        return employeeResponse;
    }
}
