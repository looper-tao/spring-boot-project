package com.boot.plus.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yeguxin
 * @date: 2019/9/26
 * @description:
 */
@SpringBootApplication
@Configuration
@RestController
@EntityScan(basePackages = {"com.boot.plus.mybatis"})
@MapperScan(basePackages = {"com.boot.plus.mybatis.dao"})
public class MybatisPlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class);
    }
    
}
