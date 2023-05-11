package com.wendy.employeeservice.service.serviceImpl;

import com.wendy.employeeservice.dto.ApiResponseDto;
import com.wendy.employeeservice.dto.DepartmentDto;
import com.wendy.employeeservice.dto.EmployeeDto;
import com.wendy.employeeservice.entity.Employee;
import com.wendy.employeeservice.repository.EmployeeRepository;
import com.wendy.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
private final EmployeeRepository employeeRepository;
private final RestTemplate restTemplate;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return mapToEmployeeDto(savedEmployee);
    }

    @Override
    public ApiResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/v1/department/" + employee.getDepartmentCode(),
                DepartmentDto.class);
        DepartmentDto departmentDto = responseEntity.getBody();
        EmployeeDto employeeDto = mapToEmployeeDto(employee);
        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
    return apiResponseDto;
    }

    private EmployeeDto mapToEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setDepartmentCode(employee.getDepartmentCode());
        return employeeDto;
    }

    private Employee mapToEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setEmail(employeeDto.getEmail());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setDepartmentCode(employeeDto.getDepartmentCode());
        return employee;

    }
}
