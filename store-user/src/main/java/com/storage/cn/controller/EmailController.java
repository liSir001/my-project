package com.storage.cn.controller;

import com.storage.cn.service.MailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@Api(tags = "邮箱验证接口")
@RestController
@RequestMapping("/api/email")
@Slf4j
public class EmailController {

    @Autowired
    private MailService mailService;

    /**
     * 邮箱验证
     * @param email 邮箱
     * @return
     */
    @ApiOperation(value = "邮箱验证", produces = APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParam(name = "email", value = "邮箱", required = true, paramType = "String")
    @GetMapping(path = "/send", produces = APPLICATION_JSON_UTF8_VALUE)
    public void sendMail(@RequestParam String email) {
        log.info("Send mail started, email:{}", email);
        mailService.queryVerifyCode(email);
        log.info("Send mail finished, email:{}", email);
    }
}
