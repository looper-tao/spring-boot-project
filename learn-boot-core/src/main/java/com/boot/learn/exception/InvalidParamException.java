package com.boot.learn.exception;

public class InvalidParamException extends ControllerException {

    private static final Integer INVALID_PARAM_EXCEPTION_CODE = -404;

    public InvalidParamException(String message) {
        super(INVALID_PARAM_EXCEPTION_CODE, message);
    }
}
