package chapter1.kai.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 部门实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer id;     // 部门id
    private String name;    // 部门名称
}
