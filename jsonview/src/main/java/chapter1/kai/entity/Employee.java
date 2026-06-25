package chapter1.kai.entity;

import chapter1.kai.view.DepartmentJsonView;
import chapter1.kai.view.EIdJsonView;
import chapter1.kai.view.ENameJsonView;
import com.fasterxml.jackson.annotation.JsonView;
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
    @JsonView(EIdJsonView.class)
    private Integer id;     // 员工id

    @JsonView(ENameJsonView.class)
    private String name;    // 员工姓名

    @JsonView(DepartmentJsonView.class)     // 需要去实体类相关字段上添加@JsonView注解，并提供相应接口
    private Department department; // 员工所在部门
}
