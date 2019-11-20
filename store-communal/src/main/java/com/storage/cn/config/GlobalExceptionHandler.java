package com.storage.cn.config;

import com.storage.cn.entity.ErrorResult;
import com.storage.cn.enums.ErrorResultCode;
import com.storage.cn.exception.StoreException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 * <p>
 * 全局异常处理
 * </p>
 *
 * @Auther: Lei Li
 * @Date: 2019/11/20 17:05
 * @Version 1.0
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResult missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException e) {
        log.error(String.format("全局异常信息, e=%s", e.getMessage()), e);
        final Integer errorCode = ErrorResultCode.EMPTY_PARAM.code;
        return ErrorResult.builder().code(errorCode).message(e.getMessage()).build();
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResult methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        log.error(String.format("全局异常信息, e=%s", e.getMessage()), e);
        final Integer errorCode = ErrorResultCode.PARAM_ERROR.code;
        final String errorMessage = e.getBindingResult().getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .limit(1)
                .findFirst()
                .orElse("");
        return ErrorResult.builder().code(errorCode).message(errorMessage).build();
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResult constraintViolationExceptionHandler(ConstraintViolationException e) {
        log.error(String.format("全局异常信息, e=%s", e.getMessage()), e);
        final Integer errorCode = ErrorResultCode.PARAM_ERROR.code;
        final String errorMessage = e.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .limit(1)
                .findFirst()
                .orElse("");
        return ErrorResult.builder().code(errorCode).message(errorMessage).build();
    }

    @ExceptionHandler(value = StoreException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResult storeExceptionHandler(StoreException e) {
        log.error(String.format("全局异常信息, 异常 e=%s", e));
        final Integer errorCode = e.getResultCode().code;
        final String errorMessage = e.getResultCode().msg;
        return ErrorResult.builder().code(errorCode).message(errorMessage).build();
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResult exceptionHandler(Exception e) {
        log.error(String.format("全局异常信息 e=%s", e.getMessage()), e);
        return ErrorResult.builder()
                .code(ErrorResultCode.SERVER_ERROR.code)
                .message(ErrorResultCode.SERVER_ERROR.msg)
                .build();
    }
}
