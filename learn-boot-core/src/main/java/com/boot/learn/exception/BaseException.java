package com.boot.learn.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseException extends RuntimeException {

    protected Integer code;

    public BaseException(Integer code) {
        this.code = code;
    }

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
    }

}
