package chapter1.kai;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootTest
class JasyptApplicationTests {
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private StringEncryptor stringEncryptor;

    @Test
    public void test() {
        // 获取所有Bean定义的名字
        String[] allBeanNames = applicationContext.getBeanDefinitionNames();
        // 直接过滤并打印可能包含jasypt的Bean
        System.out.println("======= 检查Jasypt相关Bean =======");
        Arrays.stream(allBeanNames)
                .filter(name -> name.contains("jasypt"))
                .sorted()
                .forEach(name -> System.out.println("找到Jasypt相关Bean: " + name));
        System.out.println("======= 检查完毕 =======");
    }

    @Test
    public void test2() {
        // 加密
        String password = "123456";
        String encryptedPassword = stringEncryptor.encrypt(password);
        System.out.println("加密后的密码: " + encryptedPassword);

        // 解密
        String decryptedPassword = stringEncryptor.decrypt(encryptedPassword);
        System.out.println("解密后的密码: " + decryptedPassword);
    }

    @Test
    public void test3() {
        // 获取数据库密码
        Environment env = applicationContext.getEnvironment();
        String password = env.getProperty("spring.datasource.druid.password");
        System.out.println("数据库密码: " + password);
    }
}
