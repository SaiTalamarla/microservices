package learn.microservices.employeeservice.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import learn.microservices.employeeservice.dto.DepartmentDto;


@FeignClient(url="http://localhost:8081",value="department-service")
public interface DepartmentAPIClient {
    @GetMapping("api/departments/{department-code}")
    DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);
}
