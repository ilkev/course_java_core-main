package com.java.course.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionAmountException extends RuntimeException{
    public QuestionAmountException() {
    }

    public QuestionAmountException(String message) {
        super(message);
    }

    public QuestionAmountException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionAmountException(Throwable cause) {
        super(cause);
    }

    public QuestionAmountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
