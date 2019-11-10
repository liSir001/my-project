package com.storage.cn.service.impl;

import com.storage.cn.util.SendMailUtils;
import com.storage.cn.util.UUIDUtils;
import lombok.extern.slf4j.Slf4j;
import com.storage.cn.service.MailService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MailServiceImpl implements MailService {

    @Override
    public void queryVerifyCode(String email) {
        // 主题
        final String subject = "用户激活认证邮件";
        // 内容
        final String content = String.format("<h1>验证码:%S</h1>", UUIDUtils.getUUID());
        // 发送激活邮件
        SendMailUtils.sendHtmlMail(email, subject, content);
    }
}
