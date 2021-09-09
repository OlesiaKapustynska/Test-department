package com.example.testdepartment.service;

import com.example.testdepartment.model.Employee;
import java.util.List;

public interface EmployeeService {
    Employee get(Long id);

    List<Employee> getAll(Long pageSize, Long pageNumber);

    List<Employee> findBySearch(String search, Long pageSize, Long pageNumber);

    Employee update(Long id, Employee employee);

    boolean delete(Long id);
}
