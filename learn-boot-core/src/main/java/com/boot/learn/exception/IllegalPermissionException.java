package com.boot.learn.exception;

public class IllegalPermissionException extends ControllerException {

    private static final Integer ILLEGAL_PERMISSION_EXCEPTION_CODE = -403;

    public IllegalPermissionException(String message) {
        super(ILLEGAL_PERMISSION_EXCEPTION_CODE, message);
    }

}
