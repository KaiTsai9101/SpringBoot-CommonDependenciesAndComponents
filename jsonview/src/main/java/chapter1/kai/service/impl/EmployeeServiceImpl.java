package chapter1.kai.service.impl;

import chapter1.kai.entity.Department;
import chapter1.kai.entity.Employee;
import chapter1.kai.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    // 声明员工集合
    private List<Employee> employees;

    // 构造方法初始化员工集合的实例
    public EmployeeServiceImpl() {
        // 3个部门
        Department technology = new Department(1, "技术部");
        Department product = new Department(2, "产品部");
        Department sales = new Department(3, "销售部");
        // 5个员工
        this.employees = List.of(
                new Employee(101, "张三", technology),
                new Employee(102, "李四", technology),
                new Employee(103, "王五", product),
                new Employee(104, "赵六", product),
                new Employee(105, "钱七", sales)
        );
    }

    // 查找指定id的员工，否则返回null
    public Employee getEmployeeById(Integer employeeId) {
        return this.employees.stream()
                .filter(employee -> employee.getId().equals(employeeId))
                .findFirst()
                .orElse(null);
    }
}
