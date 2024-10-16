package learn.microservices.employeeservice.service;


import learn.microservices.employeeservice.dto.APIResponseDto;
import learn.microservices.employeeservice.dto.EmployeeDto;
import learn.microservices.employeeservice.dto.DepartmentDto;
import learn.microservices.employeeservice.entity.Employee;
import learn.microservices.employeeservice.mapper.EmployeeMapper;
import learn.microservices.employeeservice.repository.EmployeeRepository;
import learn.microservices.employeeservice.service.client.DepartmentAPIClient;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private EmployeeRepository employeeRepository;

    private DepartmentAPIClient departmentAPIClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee saveDEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(saveDEmployee);
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {

       Employee employee = employeeRepository.findById(employeeId).get();

        DepartmentDto department = departmentAPIClient.getDepartment(employee.getDepartmentCode());
        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(department);
        return apiResponseDto;
    }
}
