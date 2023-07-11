package com.cwru.platform;

import com.cwru.platform.dao.DiscussPostMapper;
import com.cwru.platform.dao.UserMapper;
import com.cwru.platform.entity.DiscussPost;
import com.cwru.platform.entity.User;

import com.cwru.platform.util.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Date;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = PlatformApplication.class)

public class MailTests {

    @Autowired
    public MailClient mailClient;

    @Test
    public void testTextMail(){
        mailClient.sendMail("dxx128@case.edu", "TEXT", "测试邮件功能");
    }

    @Autowired
    private TemplateEngine templateEngine;



    @Test
    public void testHtmlMail(){

        Context context = new Context();
        // 把参数传入thymeleaf模板，实现动态化
        context.setVariable("username", "sunday");

        String content = templateEngine.process("mail/demo", context);
        System.out.println(content);
        mailClient.sendMail("dxx128@case.edu", "HTML", content);
    }

}
