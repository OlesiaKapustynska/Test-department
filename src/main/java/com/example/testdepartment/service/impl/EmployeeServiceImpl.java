package com.example.testdepartment.service.impl;

import com.example.testdepartment.dao.EmployeeDao;
import com.example.testdepartment.model.Employee;
import com.example.testdepartment.service.EmployeeService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public Employee get(Long id) {
        return employeeDao.get(id).orElseThrow();
    }

    @Override
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    @Override
    public List<Employee> findBySearch(String search) {
        return employeeDao.findBySearch(search);
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
