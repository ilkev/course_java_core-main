package com.java.course.exceptions;

public class StorageIsEmpty extends RuntimeException {
    public StorageIsEmpty() {
    }

    public StorageIsEmpty(String message) {
        super(message);
    }

    public StorageIsEmpty(String message, Throwable cause) {
        super(message, cause);
    }

    public StorageIsEmpty(Throwable cause) {
        super(cause);
    }

    public StorageIsEmpty(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
