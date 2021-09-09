package com.example.testdepartment.service;

import com.example.testdepartment.model.Department;
import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    List<Department> getAll();
    Department getById(Long id);
}
