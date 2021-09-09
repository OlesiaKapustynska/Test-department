package com.example.testdepartment.controller;

import com.example.testdepartment.model.Employee;
import com.example.testdepartment.model.dto.EmployeeRequestDto;
import com.example.testdepartment.model.dto.EmployeeResponseDto;
import com.example.testdepartment.service.AuthenticationService;
import com.example.testdepartment.service.mapper.EmployeeMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final EmployeeMapper employeeMapper;

    public AuthenticationController(AuthenticationService authenticationService,
                                    EmployeeMapper employeeMapper) {
        this.authenticationService = authenticationService;
        this.employeeMapper = employeeMapper;
    }

    @PostMapping("/register")
    @ApiOperation(value = " Registers a new employee ")
    public EmployeeResponseDto register(@RequestBody EmployeeRequestDto employeeRequestDto) {
        Employee employee = employeeMapper.mapToModel(employeeRequestDto);
        return employeeMapper.mapToDto(authenticationService.register(employee));
    }
}
