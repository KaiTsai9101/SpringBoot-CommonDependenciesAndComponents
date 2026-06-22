package chapter1.kai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
@CrossOrigin
public class UserPhotoController {
    @GetMapping("/userPhoto")
    public void userPhoto(HttpServletResponse response) throws IOException {
        // 获取当前登录用户的信息
        String photo = "default.png";
        // 获取当前用户的头像文件
        String path = ResourceUtils.getURL("upload").getPath();
        File file = new File(path + File.separator + photo);
        // 向前端响应信息（流）
        FileInputStream fis = new FileInputStream(file);
        byte[] b = new byte[fis.available()];       // fis.available()表示fis文件大小
        fis.read(b);
        // 输出对象
        ServletOutputStream out = response.getOutputStream();
        out.write(b);
        fis.close();
        out.close();
    }
}
