package learn.microservices.employeeservice.service;

import learn.microservices.employeeservice.dto.APIResponseDto;
import learn.microservices.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
