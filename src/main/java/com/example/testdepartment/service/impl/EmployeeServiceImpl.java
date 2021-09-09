package com.example.testdepartment.service.impl;

import com.example.testdepartment.dao.EmployeeDao;
import com.example.testdepartment.model.Employee;
import com.example.testdepartment.service.EmployeeService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Employee get(Long id) {
        return employeeDao.get(id).orElseThrow();
    }

    @Override
    public List<Employee> getAll(Long pageSize, Long pageNumber) {
        return employeeDao.getAll(pageSize, pageNumber);
    }

    @Override
    public List<Employee> findBySearch(String search, Long pageSize, Long pageNumber) {
        return employeeDao.findBySearch(search, pageSize, pageNumber);
    }

    @Override
    public Employee update(Long id, Employee employee) {
        return employeeDao.update(id, employee);
    }

    @Override
    public boolean delete(Long id) {
        return employeeDao.delete(id);
    }
}
