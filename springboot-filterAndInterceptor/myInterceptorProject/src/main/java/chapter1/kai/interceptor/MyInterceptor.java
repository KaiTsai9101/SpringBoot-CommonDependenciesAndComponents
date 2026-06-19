package chapter1.kai.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Objects;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 记录IP访问次数
        // 访问的ip
        String ip = request.getRemoteAddr();
        // 统计访问次数并输出
        HttpSession session = request.getSession();
        Integer count = (Integer) session.getAttribute("count");
        count = Objects.isNull(count) ? 1 : count + 1;
        System.out.println("ip: " + ip + "\tcount: " + count);
        session.setAttribute("count", count);
        // 放行
        return true;
    }
}
