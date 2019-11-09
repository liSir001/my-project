package com.storage.cn.exception;

import com.storage.cn.enums.Error;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description: 全局异常处理
 * @Auther: Lei Li
 * @Date: 2019/11/9 12:43
 * @Version 1.0
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = StoreException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Error StoreExceptionHandler(StoreException e) {
        final int code = e.getErrorCode().code;
        final String message = e.getErrorCode().msg;
        return Error.builder().code(code).message(message).build();
    }
}
