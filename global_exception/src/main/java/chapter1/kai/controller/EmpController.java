package chapter1.kai.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
public class EmpController {
    // 保存部门的集合
    private Map<Long, String> empMap = new HashMap<>();

    public EmpController() {
        // 初始化数据
        empMap.put(101L, "张三");
        empMap.put(102L, "李四");
        empMap.put(103L, "王五");
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/emps/{id}")
    public Map<String, Object> deleteEmp(@PathVariable String id) {
        // 1.参数校验异常：ID为空或格式不正确
        // （springboot2.4后@DeleteMapping("/emps/{id}",@PathVariable为默认)就一定要写id）所以这里这个if没意义
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("员工ID不能为空");
        }
        // 2.检查ID格式（假设ID必须是数字）
        if (!id.matches("\\d+")) {
            throw new IllegalArgumentException("员工ID格式不正确，必须是数字");
        }
        // 3.业务逻辑异常：用户不存在
        Long longId = Long.parseLong(id);       // 将字符串转换为Long类型
        if (!empMap.containsKey(longId)) {
            throw new RuntimeException("员工ID" + id + "不存在，无法删除");
        }

        // 正常删除逻辑
        String deletedEmp = empMap.remove(longId);

        // 返回成功响应
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("errorCode", 0);
        response.put("errorMessage", "");
        response.put("data", Collections.singletonMap("deletedEmp", deletedEmp));
        response.put("timestamp", System.currentTimeMillis());
        response.put("message", "部门删除成功");
        return response;
    }

//    /** 处理IllegalArgumentException异常 */
//    @ExceptionHandler(IllegalArgumentException.class)
//    public Map<String, Object> handleIllegalArgumentException(IllegalArgumentException e) {
//        Map<String, Object> errorResponse = new HashMap<>();
//        errorResponse.put("success", false);
//        errorResponse.put("errorCode", 4001);   // 自定义错误码
//        errorResponse.put("errorMessage", "参数校验失败: " + e.getMessage());
//        errorResponse.put("data", Collections.emptyMap());
//        errorResponse.put("timestamp", System.currentTimeMillis());
//        errorResponse.put("handler", "EmpController-参数校验异常处理器");
//        return errorResponse;
//    }
//
//    /** 处理RuntimeException异常 */
//    @ExceptionHandler(RuntimeException.class)
//    public Map<String, Object> handleRuntimeException(RuntimeException e) {
//        Map<String, Object> errorResponse = new HashMap<>();
//        errorResponse.put("success", false);
//        errorResponse.put("errorCode", 4041);   // 自定义错误码
//        errorResponse.put("errorMessage", "业务错误: " + e.getMessage());
//        errorResponse.put("data", Collections.emptyMap());
//        errorResponse.put("timestamp", System.currentTimeMillis());
//        errorResponse.put("handler", "EmpController-业务异常处理器");
//        return errorResponse;
//    }
//
//    /** 处理其他异常 */
//    @ExceptionHandler(Exception.class)
//    public Map<String, Object> handleException(Exception e) {
//        Map<String, Object> errorResponse = new HashMap<>();
//        errorResponse.put("success", false);
//        errorResponse.put("errorCode", 5001);   // 自定义错误码
//        errorResponse.put("errorMessage", "系统内部错误，请稍后重试");
//        errorResponse.put("data", Collections.emptyMap());
//        errorResponse.put("timestamp", System.currentTimeMillis());
//        errorResponse.put("handler", "EmpController-全局异常处理器");
//        return errorResponse;
//    }
}
