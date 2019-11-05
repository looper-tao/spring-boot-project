package com.boot.plus.mybatis.controller;

import com.boot.plus.mybatis.entity.TPerson;
import com.boot.plus.mybatis.service.PersonService;
import com.boot.plus.mybatis.service.impl.PersonImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: yeguxin
 * @date: 2019/9/26
 * @description:
 */
@RequestMapping("mybatis/plus")
@RestController
public class PersonController {
    @Autowired
    private PersonService personService;
    
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public List<TPerson> getPersonList(){
        return personService.selectAll();
    }

}