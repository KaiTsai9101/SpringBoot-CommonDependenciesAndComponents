package chapter1.kai.mode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseModel<T> implements Serializable {
    /**
     * http响应码
     */
    private Integer code;
    /**
     * 响应信息
     */
    private String msg;
    /**
     * 响应数据
     */
    private T data;
    /**
     * 响应成功
     */
    public static <T> ResponseModel<T> success(T data) {
        ResponseModel rm = new ResponseModel(200, "success", data);
        return rm;
    }
    /**
     * 响应失败
     */
    public static <T> ResponseModel<T> failure(T data) {
        ResponseModel rm = new ResponseModel(500, "failure", data);
        return rm;
    }
}
