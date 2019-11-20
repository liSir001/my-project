package com.storage.cn.exception;

/**
 * @Auther: Lei Li
 * @Date: 2019/11/19 16:13
 * @Version 1.0
 */
public class StoreException extends RuntimeException {
    public StoreException() {
    }

    public StoreException(String message) {
        super(message);
    }

    public StoreException(String message, Throwable cause) {
        super(message, cause);
    }

    public StoreException(Throwable cause) {
        super(cause);
    }

    public StoreException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
