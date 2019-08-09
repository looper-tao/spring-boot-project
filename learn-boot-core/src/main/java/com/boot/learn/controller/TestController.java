package com.boot.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("boot/test")
public class TestController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String test() {
        return "SUCCESS";
    }
    
    
}
