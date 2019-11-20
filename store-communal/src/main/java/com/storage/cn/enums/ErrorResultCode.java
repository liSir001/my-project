package com.storage.cn.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorResultCode {

    USER_NOT_FOUND(10001, "用户找不到"),
    EMPTY_PARAM(40000, "参数为空"),
    PARAM_ERROR(10010, ""),
    SERVER_ERROR(99999, "系统内部异常");

    public final Integer code;
    public final String msg;
}
