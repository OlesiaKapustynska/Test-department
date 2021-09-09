package com.example.testdepartment.service;

import com.example.testdepartment.model.Employee;
import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);

    Employee get(Long id);

    List<Employee> getAll();

    List<Employee> findBySearch(String search);

    Employee update(Long id, Employee employee);

    boolean delete(Long id);
}
