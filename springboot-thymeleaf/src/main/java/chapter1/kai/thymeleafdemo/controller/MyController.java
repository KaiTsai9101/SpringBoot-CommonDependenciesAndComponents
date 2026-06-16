package chapter1.kai.thymeleafdemo.controller;

import chapter1.kai.thymeleafdemo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class MyController {
    @RequestMapping("/")
    public String index(Model model) {
//        model.addAttribute("user", "<a href='http://www.baidu.com'>百度</a>");
//        User user = new User("张三", "123456");
//        model.addAttribute("user", user);
//        model.addAttribute("age", 17);
        User user1 = new User("张三", "123456");
        User user2 = new User("李四", "111111");
        User user3 = new User("王五", "123123");
        List<User> userList = Arrays.asList(user1, user2, user3);
        model.addAttribute("userList", userList);

        return "index";     // /views/+index（模板文件的主文件名）+.html-> /views/index.html
    }
}
