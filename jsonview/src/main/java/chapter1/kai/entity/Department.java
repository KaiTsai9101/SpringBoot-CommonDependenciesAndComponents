package chapter1.kai.entity;

import chapter1.kai.view.DIdJsonView;
import chapter1.kai.view.DNameJsonView;
import com.fasterxml.jackson.annotation.JsonView;
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
    @JsonView(DIdJsonView.class)
    private Integer id;     // 部门id
    @JsonView(DNameJsonView.class)
    private String name;    // 部门名称
}
