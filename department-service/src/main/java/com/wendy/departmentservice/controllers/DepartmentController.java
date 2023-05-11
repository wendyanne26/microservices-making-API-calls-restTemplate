package com.wendy.departmentservice.controllers;

import com.wendy.departmentservice.dto.DepartmentDto;
import com.wendy.departmentservice.services.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/department")
public class DepartmentController {
    private final DepartmentService departmentService;
    @PostMapping("/save")
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDto = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDto, HttpStatus.OK);
    }
    @GetMapping("{departmentCode}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable String departmentCode){
       DepartmentDto foundDepartment = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(foundDepartment, HttpStatus.OK);
    }

}
