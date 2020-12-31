package com.boot.plus.mybatis.controller;

import com.boot.plus.mybatis.annotation.WriteLog;
import com.boot.plus.mybatis.entity.TPerson;
import com.boot.plus.mybatis.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: yeguxin
 * @date: 2019/9/26
 * @description:
 */
@Slf4j
@RequestMapping("mybatis/plus")
@RestController
public class PersonController {
    private final PersonService personService;
    
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<TPerson> getPersonList() {
        return personService.selectAll();
    }
    
    @WriteLog()
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public Boolean test(Integer num) {
        int result = 100 / num;
        log.info("result = " + result);
        System.out.println("res +" + num);
        return Boolean.TRUE;
    }
    
    @WriteLog(name = "测试写入log", value = {TPerson.class, Integer.class})
    @RequestMapping(value = "test1", method = RequestMethod.POST)
    public String test2(@RequestBody TPerson person, Integer num) {
        return "SUCCESS!!!   " + num;
    }
    
}

