package com.boot.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author: yeguxin
 * @date: 2020/9/10
 * @description:
 */
@SpringBootApplication
@EntityScan(basePackages = {"com.boot.security"})
@MapperScan(basePackages = {"com.boot.security.dao"})
public class SecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class);
    }
}
