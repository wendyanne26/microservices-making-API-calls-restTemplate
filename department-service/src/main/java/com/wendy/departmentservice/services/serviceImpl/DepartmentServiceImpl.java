package com.wendy.departmentservice.services.serviceImpl;

import com.wendy.departmentservice.dto.DepartmentDto;
import com.wendy.departmentservice.entity.Department;
import com.wendy.departmentservice.repositories.DepartmentRepository;
import com.wendy.departmentservice.services.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return mapToDepartmentDto(savedDepartment);

    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department foundDepartment = departmentRepository.findByDepartmentCode(code);
        return mapToDepartmentDto(foundDepartment);
    }

    public Department mapToDepartment(DepartmentDto departmentDto){
        Department department = new Department();
        department.setId(departmentDto.getId());
        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentCode(departmentDto.getDepartmentCode());
        department.setDepartmentDescription(departmentDto.getDepartmentDescription());
        return  department;
    }
    public DepartmentDto mapToDepartmentDto(Department department){
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(department.getId());
        departmentDto.setDepartmentCode(department.getDepartmentCode());
        departmentDto.setDepartmentDescription(department.getDepartmentDescription());
        departmentDto.setDepartmentName(department.getDepartmentName());
        return departmentDto;
    }
}
