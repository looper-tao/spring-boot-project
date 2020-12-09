package com.boot.plus.mybatis.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author: yeguxin
 * @date: 2020/11/30
 * @description:
 */
@ControllerAdvice
@ResponseBody
public class MyBatisPlusResponseExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public Map<String, String> handleOperationFailedException(Exception e) {
        Map<String, String> result = new TreeMap<>();
        result.put("message", e.getMessage());
        return result;
    }
}
