package com.storage.cn.exception;

/**
 * @author Lei Li
 * @version 1.0
 * @time 2019/11/9 12:35
 */
public class JsonSerializeException extends RuntimeException {

    public JsonSerializeException() {
        super();
    }

    public JsonSerializeException(String message) {
        super(message);
    }

    public JsonSerializeException(String message, Throwable cause) {
        super(message, cause);
    }

    public JsonSerializeException(Throwable cause) {
        super(cause);
    }

    protected JsonSerializeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
