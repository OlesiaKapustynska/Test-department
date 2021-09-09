package com.example.testdepartment.controller;

import com.example.testdepartment.model.dto.DepartmentResponseDto;
import com.example.testdepartment.service.DepartmentService;
import com.example.testdepartment.service.mapper.DepartmentMapper;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentMapper departmentMapper;
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentMapper departmentMapper,
                                DepartmentService departmentService) {
        this.departmentMapper = departmentMapper;
        this.departmentService = departmentService;
    }

    @GetMapping
    @ApiOperation(value = " Returns a list of all departments ")
    public List<DepartmentResponseDto> getAll() {
        return departmentService.getAll().stream()
                .map(departmentMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
