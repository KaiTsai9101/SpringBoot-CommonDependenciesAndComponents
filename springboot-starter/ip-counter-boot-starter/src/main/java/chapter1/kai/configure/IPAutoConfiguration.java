package chapter1.kai.configure;

import chapter1.kai.service.IpCounterService;
import chapter1.kai.service.impl.IpCounterServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
public class IPAutoConfiguration {
    @Bean
    public IpCounterService ipCounterService(){
        return new IpCounterServiceImpl();
    }
}
