package dev.decagon.employeeservice.service.impl;

import dev.decagon.employeeservice.dto.EmployeeDto;
import dev.decagon.employeeservice.entity.Employee;
import dev.decagon.employeeservice.repository.EmployeeRepository;
import dev.decagon.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );

        Employee savedEmployee = employeeRepository.save(employee);

        return new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail()
        );
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {

        Optional<Employee> employee = employeeRepository.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();

        if(employee.isPresent()) {
            employeeDto.setId(employee.get().getId());
            employeeDto.setFirstName(employee.get().getFirstName());
            employeeDto.setLastName(employee.get().getLastName());
            employeeDto.setEmail(employee.get().getEmail());
        }

        return employeeDto;
    }
}
