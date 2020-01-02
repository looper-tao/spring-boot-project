package com.boot.learn.controller;

import com.boot.learn.aop.annotate.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yeguxin
 * @date: 2020/1/2
 * @description:
 */
@RestController
@RequestMapping("aop")
public class AopTestController {
    @Log(value = "测试方法")
    @GetMapping(value = "test")
    public void test(@RequestParam("param1") String param1,@RequestParam("param2") String param2){
        System.out.println("controller开始执行逻辑");
    }
}
