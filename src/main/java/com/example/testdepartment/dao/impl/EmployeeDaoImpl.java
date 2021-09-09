package com.example.testdepartment.dao.impl;

import com.example.testdepartment.dao.EmployeeDao;
import com.example.testdepartment.model.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private DataSource dataSource;

    public EmployeeDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Employee save(Employee employee) {
        String selectQuery = "INSERT INTO employees " +
                "(name, active, department_id) VALUES (?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(selectQuery, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, employee.getName());
            ps.setBoolean(2, employee.getActive());
            ps.setLong(3, employee.getDepartmentId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Can't save employee: " + employee + " to DB", e);
        }
        return employee;
    }

    @Override
    public Optional<Employee> get(Long id) {
        String selectQuery = "SELECT id, name, active, department_id "
                + "FROM employees " +
                "WHERE id = ?";
        Employee employee = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                employee = parseEmployeeFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can't get employee by id: " + id, e);
        }
        return Optional.ofNullable(employee);
    }

    @Override
    public List<Employee> getAll() {
        String selectQuery = "SELECT id, name, active, department_id "
                + "FROM employees";
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employees.add(parseEmployeeFromResultSet(resultSet));
            }
            return employees;
        } catch (SQLException e) {
            throw new RuntimeException("Can't get all employees", e);
        }
    }

    @Override
    public List<Employee> findBySearch(String search) {
        String selectQuery = "SELECT id, name, active, department_id "
                + "FROM employees "
                + "WHERE name LIKE ?";
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setString(1, search + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employees.add(parseEmployeeFromResultSet(resultSet));
            }
            return employees;
        } catch (SQLException e) {
            throw new RuntimeException("Can't get all employees", e);
        }
    }

    @Override
    public Employee update(Long id, Employee employee) {
        String selectQuery = "UPDATE employees SET name = ?, active = ?, department_id = ? WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setBoolean(2, employee.getActive());
            preparedStatement.setLong(3, employee.getDepartmentId());
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Can't update employee " + employee, e);
        }
        return employee;
    }

    @Override
    public boolean delete(Long id) {
        String selectQuery = "UPDATE employees SET active = false WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Can't make on not active employee by id " + id, e);
        }
    }

    private Employee parseEmployeeFromResultSet(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getObject("id", Long.class);
        String employeeName = resultSet.getNString("name");
        Boolean employeeActive = resultSet.getBoolean("active");
        Long departmentId = resultSet.getObject("department_id", Long.class);
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(employeeName);
        employee.setActive(employeeActive);
        employee.setDepartmentId(departmentId);
        return employee;
    }
}
