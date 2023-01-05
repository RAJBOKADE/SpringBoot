package com.example.manytomany.mapper;

import com.example.manytomany.entity.DepartmentEntity;
import com.example.manytomany.model.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    Department entityToModel (DepartmentEntity departmentEntity);
    DepartmentEntity modelToEntity (Department department);
}
