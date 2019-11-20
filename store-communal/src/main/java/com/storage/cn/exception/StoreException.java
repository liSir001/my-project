package com.storage.cn.exception;

import lombok.Data;
import lombok.NonNull;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import com.storage.cn.enums.ErrorResultCode;

/**
 * @Auther: Lei Li
 * @Date: 2019/11/20 17:08
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class StoreException extends RuntimeException {

    @NonNull
    private ErrorResultCode resultCode;
}
