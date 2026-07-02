package chapter1.kai.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // 头部信息
                .info(new Info()
                        .title("部门管理API")
                        .version("1.0.0")
                        .description("Spring Boot 3.5.16 集成 Swagger/OpenAPI 示例")
                        .contact(new Contact()
                                .name("KaiTsai")
                                .email("contact@example.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("项目文档")
                        .url("https://github.com/kaitsai9101"));
    }
}
