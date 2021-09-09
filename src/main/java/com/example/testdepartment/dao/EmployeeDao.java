package com.example.testdepartment.dao;

import com.example.testdepartment.model.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeDao {
    Employee save(Employee employee);

    Optional<Employee> get(Long id);

    List<Employee> getAll();

    List<Employee> findBySearch(String search);

    Employee update(Long id, Employee employee);

    boolean delete(Long id);
}
