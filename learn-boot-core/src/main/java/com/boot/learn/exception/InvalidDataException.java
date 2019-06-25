package com.boot.learn.exception;

public class InvalidDataException extends ControllerException {

    private static final Integer INVALID_DATA_EXCEPTION_CODE = -405;

    public InvalidDataException(String message) {
        super(INVALID_DATA_EXCEPTION_CODE, message);
    }
}
