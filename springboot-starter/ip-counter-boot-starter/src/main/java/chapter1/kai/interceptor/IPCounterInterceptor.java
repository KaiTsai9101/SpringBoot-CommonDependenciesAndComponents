package chapter1.kai.interceptor;

import chapter1.kai.service.IpCounterService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

public class IPCounterInterceptor implements HandlerInterceptor {
    @Autowired
    private IpCounterService ipCounterService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ipCounterService.record();
        return true;
    }
}
