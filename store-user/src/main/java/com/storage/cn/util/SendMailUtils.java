package com.storage.cn.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.UUID;

/**
 * @Auther: Lei Li
 * @Date: 2019/11/10 15:16
 * @Version 1.0
 */
@Component
@Slf4j
public class SendMailUtils {
    /**
     * Spring Boot 提供了一个发送邮件的简单抽象，使用的是下面这个接口，这里直接注入即可使用
     */
    @Autowired
    private JavaMailSender mailSender;
    private static SendMailUtils instance;
    /**
     * 配置文件中配置个人邮箱
     */
    @Value("${spring.mail.from}")
    private String from;

    @PostConstruct
    public void init() {
        SendMailUtils.instance = this;
    }

    /**
     * 简单文本邮件
     *
     * @param to 收件人
     */
    public static void sendSimpleMail(String to, String subject, String content) {
        //创建SimpleMailMessage对象
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件发送人
        message.setFrom(instance.from);
        //邮件接收人
        message.setTo(to);
        //邮件主题
        message.setSubject(subject);
        //邮件内容
        message.setText(content);
        //发送邮件
        instance.mailSender.send(message);
    }

    /**
     * html邮件
     *
     * @param to      收件人
     * @param subject 主题
     * @param content 内容
     */
    public static void sendHtmlMail(String to, String subject, String content) {
        //获取MimeMessage对象
        MimeMessage message = instance.mailSender.createMimeMessage();
        MimeMessageHelper messageHelper;
        try {
            messageHelper = new MimeMessageHelper(message, true);
            //邮件发送人
            messageHelper.setFrom(instance.from);
            //邮件接收人
            messageHelper.setTo(to);
            //邮件主题
            message.setSubject(subject);
            //邮件内容，html格式
            messageHelper.setText(content, true);

            //发送
            instance.mailSender.send(message);
            //日志信息
            log.info("sendHtmlMail success.from:" + instance.from);
        } catch (MessagingException e) {
            log.error("sendHtmlMail fail.", e);
        }
    }

    /**
     * 带附件的邮件
     *
     * @param to       收件人
     * @param subject  主题
     * @param content  内容
     * @param filePath 附件
     */
    public static void sendAttachmentsMail(String to, String subject, String content, String filePath) {
        MimeMessage message = instance.mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(instance.from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);
            instance.mailSender.send(message);
            //日志信息
            log.info("邮件已经发送。");
        } catch (MessagingException e) {
            log.error("发送邮件时发生异常！", e);
        }
    }

    /**
     * 发送正文中有静态资源的邮件
     *
     * @param to
     * @param subject
     * @param content
     * @param rscPath
     * @param rscId
     */
    public static void sendResourceMail(String to, String subject, String content, String rscPath, String rscId) {
        try {
            MimeMessage message = instance.mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(instance.from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            FileSystemResource res = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId, res);
            instance.mailSender.send(message);
        } catch (MessagingException e) {
            log.error("发送邮件时发生异常！", e);
        }
    }
}
