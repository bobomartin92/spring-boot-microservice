package dev.decagon.employeeservice.service;

import dev.decagon.employeeservice.dto.ApiResponseDto;
import dev.decagon.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    ApiResponseDto getEmployeeById(Long id);
}
