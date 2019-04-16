package com.boot.learn.service;

import com.boot.learn.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: taozhengzhi
 * @Date: 2019/4/16 下午2:11
 * @Version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;
    
    @Test
    public void Test(){
        List<Student> students = studentService.quertDslTest();
        
        System.out.println(students);
    }
}
