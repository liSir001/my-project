package com.storage.cn.service;

/**
 * 封装发邮件的接口
 */
public interface MailService {

    /**
     * 邮箱验证
     * @param email
     * @return
     */
    void queryVerifyCode(String email);
}
