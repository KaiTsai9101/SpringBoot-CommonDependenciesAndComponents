package chapter1.kai.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Objects;

/**
 * 自定义过滤器：实现根据IP地址进行访问次数统计
 */
@WebFilter(urlPatterns = "/*")
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 访问的ip
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String ip = request.getRemoteAddr();
        // 统计访问次数并输出
        HttpSession session = request.getSession();
        Integer count = (Integer) session.getAttribute("count");
        count = Objects.isNull(count) ? 1 : count + 1;
        System.out.println("ip: " + ip + "\tcount: " + count);
        session.setAttribute("count", count);
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
