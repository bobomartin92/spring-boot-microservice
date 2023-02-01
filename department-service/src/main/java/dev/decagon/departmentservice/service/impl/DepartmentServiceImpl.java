package dev.decagon.departmentservice.service.impl;

import dev.decagon.departmentservice.dto.DepartmentDto;
import dev.decagon.departmentservice.entity.Department;
import dev.decagon.departmentservice.mapper.DepartmentMapper;
import dev.decagon.departmentservice.repository.DepartmentRepository;
import dev.decagon.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Department department = DepartmentMapper.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartment(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        return DepartmentMapper.mapToDepartmentDto(department);
    }
}
