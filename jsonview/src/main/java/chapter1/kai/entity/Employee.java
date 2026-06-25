package chapter1.kai.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 员工实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer id;     // 员工id
    private String name;    // 员工姓名
    private Department department; // 员工所在部门
}
