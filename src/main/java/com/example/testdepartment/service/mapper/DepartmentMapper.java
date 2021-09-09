package com.example.testdepartment.service.mapper;

import com.example.testdepartment.model.Department;
import com.example.testdepartment.model.dto.DepartmentResponseDto;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {
    public DepartmentResponseDto mapToDto(Department department) {
        DepartmentResponseDto responseDto = new DepartmentResponseDto();
        responseDto.setId(department.getId());
        responseDto.setName(department.getName().name());
        return responseDto;
    }
}
