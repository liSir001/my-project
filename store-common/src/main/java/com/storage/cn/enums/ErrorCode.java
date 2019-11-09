package com.storage.cn.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Description: 异常枚举类
 * @Auther: Lei Li
 * @Date: 2019/11/9 12:55
 * @Version 1.0
 */
@Getter
@AllArgsConstructor
public enum  ErrorCode {

    STRATEGY_NOT_FOUND(10001, "策略找不到"),
    STRATEGY_NAME_EXIST(10002, "策略名称已存在"),
    STRATEGY_CODE_EXIST(10003, "策略代码已存在"),
    STRATEGY_NOT_EXIST(10004, "策略ID不存在"),
    DRIVER_DATA_SOURCE_NOT_FOUND(20001, "驱动数据源找不到"),
    DRIVER_DATA_SOURCE_FIELD_NOT_FOUND(20002, "驱动数据源字段找不到"),
    EXTERNAL_DATA_SOURCE_NOT_FOUND(30001, "外部数据源找不到"),
    EXTERNAL_DATA_SOURCE_TAG_NOT_FOUND(30002, "外部数据源标签找不到"),
    EXTERNAL_DATA_SOURCE_TAG_NAME_EXIST(30003, "离线标签组名称已存在"),
    EXTERNAL_DATA_SOURCE_TAG_NOT_EXIST(30004, "离线标签组ID不存在"),
    EXTERNAL_DATA_SOURCE_TAG_IN_USE(30005, "离线标签组正被策略使用"),
    EXTERNAL_DATA_SOURCE_TAG_FIELD_NOT_FOUND(30006, "离线标签组字段找不到"),
    EMPTY_PARAM(40000, "参数为空"),
    PARAM_ERROR(10010, ""),
    SERVER_ERROR(99999, "系统内部异常!")
    ;

    public final int code;

    public final String msg;
}
