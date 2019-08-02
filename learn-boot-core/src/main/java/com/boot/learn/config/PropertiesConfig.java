package com.boot.learn.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author: taozhengzhi
 * @Date: 2019/7/23 下午3:45
 * @Version 1.0
 */
@Component
@Getter
@Setter
@PropertySource("classpath:application.yml")
@ConfigurationProperties(
    prefix = "user")
public class PropertiesConfig {
    private String name;
    
    private Integer age;
    
    private String school;
    
    private List<String> subject;
    
    private Map<String,Integer> achievement;
}