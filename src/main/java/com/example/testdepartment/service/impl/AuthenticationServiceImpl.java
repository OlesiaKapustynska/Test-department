package com.example.testdepartment.service.impl;

import com.example.testdepartment.dao.EmployeeDao;
import com.example.testdepartment.model.Employee;
import com.example.testdepartment.service.AuthenticationService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final EmployeeDao employeeDao;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationServiceImpl(EmployeeDao employeeDao, PasswordEncoder passwordEncoder) {
        this.employeeDao = employeeDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Employee register(Employee employee) {
        return employeeDao.save(employee);
    }

}
