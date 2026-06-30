package chapter1.kai.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "部门实体")
public class Department {
    @Schema(description = "部门ID", example = "1")
    private Long deptId;
    @Schema(description = "部门名称", example = "技术部", requiredMode = Schema.RequiredMode.REQUIRED)
    private String deptName;
    @Schema(description = "部门描述", example = "负责技术研发")
    private String description;
    @Schema(description = "部门编码", example = "TECH")
    private String deptCode;
}
