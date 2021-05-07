package com.dong.mapper;

import com.dong.model.Department;

public interface DepartmentMapper {

    Department getDeptById(Integer id);

    Department getDeptByIdPlus(Integer id);

    Department getDeptByIdStep(Integer id);
}
