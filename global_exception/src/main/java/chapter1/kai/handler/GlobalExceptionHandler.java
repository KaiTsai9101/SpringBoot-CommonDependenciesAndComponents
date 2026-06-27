package chapter1.kai.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理器
 * 使用 @RestControllerAdvice 注解，对所有 @Controller 和 @RestController 生效
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理参数校验异常
     * 包括: IllegalArgumentException 等参数相关异常
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public Map<String, Object> handleAllExceptions(IllegalArgumentException e) {
        return buildErrorResponse(
                4001,
                "参数校验失败: " + e.getMessage(),
                "Global-参数校验异常处理器"
        );
    }

    /**
     * 处理业务逻辑异常
     * 包括: RuntimeException 等业务相关异常
     */
    @ExceptionHandler(RuntimeException.class)
    public Map<String, Object> handleBusinessExceptions(RuntimeException e) {
        return buildErrorResponse(
                4041,
                "业务错误: " + e.getMessage(),
                "Global-业务异常处理器"
        );
    }

    /**
     * 处理其他所有异常
     */
    @ExceptionHandler(Exception.class)
    public Map<String, Object> handleException(Exception e) {
        return buildErrorResponse(
                5001,
                "系统内部错误，请稍后重试" + e.getMessage(),
                "Global-全局异常处理器"
        );
    }

    /**
     * 构建统一的错误响应
     */
    private Map<String, Object> buildErrorResponse(int errorCode, String errorMessage, String handler) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("success", false);
        errorResponse.put("errorCode", errorCode);   // 自定义错误码
        errorResponse.put("errorMessage", errorMessage);
        errorResponse.put("data", Collections.emptyMap());
        errorResponse.put("timestamp", System.currentTimeMillis());
        errorResponse.put("handler", handler);
        return errorResponse;
    }
}
