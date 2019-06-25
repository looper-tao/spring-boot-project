package com.boot.learn.exception;

public class InternalServiceException extends ControllerException {

    private static final Integer INTERNAL_SERVICE_EXCEPTION_CODE = -500;

    public InternalServiceException(String message) {
        super(INTERNAL_SERVICE_EXCEPTION_CODE, message);
    }
}
