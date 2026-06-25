package chapter1.kai.controller;

import chapter1.kai.entity.Employee;
import chapter1.kai.service.EmployeeService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Resource
    private EmployeeService employeeService;

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(Integer employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }
}
