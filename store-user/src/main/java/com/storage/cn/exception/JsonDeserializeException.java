package com.storage.cn.exception;

/**
 * @author Lei Li
 * @time 2019/11/9 12:36
 * @version 1.0
 */
public class JsonDeserializeException extends RuntimeException {

    public JsonDeserializeException() {
        super();
    }

    public JsonDeserializeException(String message) {
        super(message);
    }

    public JsonDeserializeException(String message, Throwable cause) {
        super(message, cause);
    }

    public JsonDeserializeException(Throwable cause) {
        super(cause);
    }

    protected JsonDeserializeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
