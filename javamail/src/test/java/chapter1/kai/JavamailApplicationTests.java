package chapter1.kai;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.io.File;

@SpringBootTest
class JavamailApplicationTests {

    @Autowired
    private JavaMailSender sender;

    private String subject = "邮件标题";
    private String content = "邮件正文";
    private String to = "收件人邮件地址";      // 这里需要修改成真正的收件人邮件地址
    private String from = "发件人邮件地址";    // 这里需要修改成真正的发件人邮件地址

    // 简单邮件
    @Test
    public void testSendSimpleMail() {
        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setSubject(subject);
        mail.setText(content);
        mail.setFrom(from);
        mail.setTo(to);

        sender.send(mail);
        System.out.println("邮件发送成功");
    }

    // 复杂邮件
    @Test
    public void testSendMimeMail() throws MessagingException {
        MimeMessage mail = sender.createMimeMessage();
        // 使用辅助类，并开启HTTP协议中用于混合数据传输的格式，用于接收附件
        MimeMessageHelper helper = new MimeMessageHelper(mail, true);
        File file = new File("附件路径");   // 这里需要修改成真正的附件路径

        helper.setSubject(subject);
        helper.setText(content +
                "<img src='https://img1.baidu.com/it/u=3973585640,2349487363&fm=253&fmt=auto&app=138&f=JPEG?w=650&h=420'>",
                true);  // 解析 HTML 格式
        helper.setFrom(from);
        helper.setTo(to);
        helper.addAttachment(file.getName(), file);     // 发送附件

        sender.send(mail);
        System.out.println("邮件发送成功");
    }
}
