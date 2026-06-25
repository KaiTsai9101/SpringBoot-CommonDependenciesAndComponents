package chapter1.kai.controller;

import chapter1.kai.entity.Employee;
import chapter1.kai.view.BaseJsonView;
import chapter1.kai.view.DepartmentJsonView;
import chapter1.kai.service.EmployeeService;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Resource
    private EmployeeService employeeService;

    @GetMapping("/employees/{employeeId}")
//    @JsonView(BaseJsonView.class)
    @JsonView(DepartmentJsonView.class)
    public Employee getEmployeeById(@PathVariable Integer employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }
}
