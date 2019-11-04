package com.boot.spring.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: taozhengzhi
 * @Date: 2019/8/9 下午9:53
 * @Version 1.0
 */

@RestController
@SpringBootApplication
public class ExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class);
    }
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String test() {
        return "SUCCESS!!!";
    }
}
