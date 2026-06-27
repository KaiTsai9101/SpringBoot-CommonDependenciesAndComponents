package chapter1.kai.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DeptController {
    // 保存部门的集合
    private Map<Long, String> deptMap = new HashMap<>();

    public DeptController() {
        // 初始化数据
        deptMap.put(101L, "研发部");
        deptMap.put(102L, "财务部");
        deptMap.put(103L, "企划部");
    }

    /**
     * 删除部门
     */
    @DeleteMapping("/emp/{id}")
    public Map<String, Object> deleteEmp(@PathVariable String id) {
        // 1.参数校验异常：ID为空或格式不正确
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID不能为空");
        }
        // 2.检查ID格式（假设ID必须是数字）
        if (!id.matches("\\d+")) {
            throw new IllegalArgumentException("ID必须是数字");
        }
        // 3.业务逻辑异常：用户不存在
        Long longId = Long.parseLong(id);
        if (!deptMap.containsKey(longId)) {
            throw new RuntimeException("部门ID" + id + "不存在，无法删除");
        }

        // 正常删除逻辑
        String deletedDept = deptMap.remove(longId);

        // 返回成功响应
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("errorCode", 0);
        response.put("errorMessage", "");
        response.put("data", Collections.singletonMap("deletedDept", deletedDept));
        response.put("timestamp", System.currentTimeMillis());
        response.put("message", "部门删除成功");
        return response;
    }
}
