package com.wendy.employeeservice.service;

import com.wendy.employeeservice.dto.ApiResponseDto;
import com.wendy.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    ApiResponseDto getEmployeeById(Long id);
}
