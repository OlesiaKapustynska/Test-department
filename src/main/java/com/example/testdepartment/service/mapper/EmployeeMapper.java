package com.example.testdepartment.service.mapper;

import com.example.testdepartment.model.Employee;
import com.example.testdepartment.model.dto.EmployeeRequestDto;
import com.example.testdepartment.model.dto.EmployeeResponseDto;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public Employee mapToModel(EmployeeRequestDto dto) {
        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setActive(dto.getActive());
        employee.setDepartmentId(dto.getDepartmentId());;
        return employee;
    }

    public EmployeeResponseDto mapToDto(Employee employee) {
        EmployeeResponseDto responseDto = new EmployeeResponseDto();
        responseDto.setId(employee.getId());
        responseDto.setName(employee.getName());
        responseDto.setActive(employee.getActive());
        responseDto.setDepartmentId(employee.getDepartmentId());
        return responseDto;
    }
}
