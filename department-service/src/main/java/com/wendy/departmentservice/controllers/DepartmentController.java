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
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/api/v1/department")
public class DepartmentController {
    private DepartmentService departmentService;
    @PostMapping("/save")
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDto = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDto, HttpStatus.OK);
    }
    @GetMapping("{departmentCode}")
    public ResponseEntity<String> getDepartment(@PathVariable String departmentCode){
        departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>("found", HttpStatus.OK);
    }

}
