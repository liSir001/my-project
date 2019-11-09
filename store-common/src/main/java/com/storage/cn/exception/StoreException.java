package com.storage.cn.exception;

import com.storage.cn.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @Description: 异常类
 * @Auther: Lei Li
 * @Date: 2019/11/9 12:52
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreException extends RuntimeException {
    @NonNull
    private ErrorCode errorCode;
}
