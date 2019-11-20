package com.storage.cn.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: Lei Li
 * @Date: 2019/11/20 17:13
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResult {

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;
}
