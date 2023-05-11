package com.wendy.departmentservice.repositories;

import com.wendy.departmentservice.dto.DepartmentDto;
import com.wendy.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentCode(String departmentCode);

}
