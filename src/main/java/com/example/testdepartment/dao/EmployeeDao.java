package com.example.testdepartment.dao;

import com.example.testdepartment.model.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeDao {
    Employee save(Employee employee);

    Optional<Employee> get(Long id);

    List<Employee> getAll(Long pageSize, Long pageNumber);

    List<Employee> findBySearch(String search, Long pageSize, Long pageNumber);

    Employee update(Long id, Employee employee);

    boolean delete(Long id);
}
