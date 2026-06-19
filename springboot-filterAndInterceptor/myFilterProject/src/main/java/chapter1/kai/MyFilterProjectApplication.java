package chapter1.kai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "chapter1.kai.filter")
public class MyFilterProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyFilterProjectApplication.class, args);
    }

}
