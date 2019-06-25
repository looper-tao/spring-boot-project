package com.boot.learn.exception;



public class ControllerException extends BaseException {

    public ControllerException(Integer code) {
        super(code);
    }

    public ControllerException(Integer code, String message) {
        super(code, message);
    }

}
