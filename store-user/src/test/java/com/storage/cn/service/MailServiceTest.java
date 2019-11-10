package com.storage.cn.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {
    @Autowired
    private MailService mailService;

    @Test
    public void sendSimpleMail() {
//        mailService.sendSimpleMail("1647835111@qq.com", "主题：这是一封普通邮件", "测试普通邮件");
    }

    @Test
    public void sendHtmlMail() {
//        mailService.sendHtmlMail("1647835111@qq.com", "主题：这是一封HTML文件", "<h1>测试HTML文件</h1>");
    }
}