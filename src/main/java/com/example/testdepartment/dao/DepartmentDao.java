package com.example.testdepartment.dao;

import com.example.testdepartment.model.Department;
import java.util.List;
import java.util.Optional;

public interface DepartmentDao {
    List<Department> getAll();
    Optional<Department> getById(Long id);
}
