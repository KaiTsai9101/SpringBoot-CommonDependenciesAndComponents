package chapter1.kai.controller;

import chapter1.kai.entity.Department;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/departments")
@Tag(name = "部门管理", description = "部门相关API")
public class DepartmentController {
    @GetMapping
    @Operation(summary = "获取部门列表", description = "获取所有部门信息")
    public List<Department> getDepartments() {
        return Arrays.asList(
                new Department(1L, "技术部", "负责技术研发", "TECH"),
                new Department(2L, "销售部", "负责销售业务", "SALES")
        );
    }

    @PostMapping
    @Operation(summary = "创建部门", description = "创建新部门")
    public Department createDepartment(
            @Parameter(description = "部门对象", required = true)
            @RequestBody Department department) {
        return department;
    }
}
