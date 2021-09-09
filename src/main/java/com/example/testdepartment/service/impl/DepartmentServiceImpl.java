package com.example.testdepartment.service.impl;

import com.example.testdepartment.dao.DepartmentDao;
import com.example.testdepartment.model.Department;
import com.example.testdepartment.service.DepartmentService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentDao departmentDao;

    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public List<Department> getAll() {
        return departmentDao.getAll();
    }

    @Override
    public Department getById(Long id) {
        return departmentDao.getById(id).orElseThrow();
    }
}
