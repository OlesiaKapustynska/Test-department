package com.example.testdepartment.dao.impl;

import com.example.testdepartment.dao.DepartmentDao;
import com.example.testdepartment.model.Department;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
    private DataSource dataSource;

    public DepartmentDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Department> getAll() {
        String selectQuery = "SELECT id, name FROM departments";
        List<Department> departments = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Department department = new Department();
                department.setId(resultSet.getObject("id", Long.class));
                String name = resultSet.getString("name");
                department.setName(Enum.valueOf(Department.DepartmentName.class, name));
                departments.add(department);
            }
            return departments;
        } catch (SQLException e) {
            throw new RuntimeException("Can't get all departments", e);
        }
    }
}
