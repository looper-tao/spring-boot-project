package com.boot.learn.controller;

import com.boot.learn.entity.Student;
import com.boot.learn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: taozhengzhi
 * @Date: 2019/4/11 下午8:22
 * @Version 1.0
 */
@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public List<Student> list(){
        List<Student> students = studentService.quertDslTest();
        return students;
    }
}
