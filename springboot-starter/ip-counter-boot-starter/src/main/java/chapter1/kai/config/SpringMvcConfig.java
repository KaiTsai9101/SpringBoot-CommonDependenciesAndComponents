package chapter1.kai.config;

import chapter1.kai.interceptor.IPCounterInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(ipCounterInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public IPCounterInterceptor ipCounterInterceptor(){
        return new IPCounterInterceptor();
    }
}
