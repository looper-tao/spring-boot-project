package com.boot.learn.service.properties;

import com.boot.learn.config.PropertiesConfig;
import com.boot.learn.untils.KJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: taozhengzhi
 * @Date: 2019/7/17 下午6:50
 * @Version 1.0
 */
@Service
public class PropertiesService {
//    @Value("${user.name}")
//    private String name;
//
//    @Value("${user.age}")
//    private Integer age;
//
//    @Value("${user.school}")
//    private String school;
//
//    @Value("#{'${user.subject}'.split(',')}")
//    private List<String> subject;
//
//
//    @Autowired
//    private PropertiesConfig propertiesConfig;
//
//    public void propertiesTest() {
//        System.out.println("name = " + name);
//        System.out.println("age = " + age);
//        System.out.println("school = " + school);
//        System.out.println("subject = " + KJsonUtils.toJson(subject));
//    }
//
//    public void propertiesConfigTest() {
//        System.out.println("propertiesConfig = " + KJsonUtils.toJson(propertiesConfig));
//    }
}
