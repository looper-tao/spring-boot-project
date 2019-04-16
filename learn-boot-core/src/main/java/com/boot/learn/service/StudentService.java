package com.boot.learn.service;

import com.boot.learn.entity.QStudent;
import com.boot.learn.entity.Student;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @Author: taozhengzhi
 * @Date: 2019/4/11 下午8:34
 * @Version 1.0
 */
@Service
public class StudentService {
    private final JPAQueryFactory queryFactory;
    
    @Autowired
    public StudentService(EntityManager em){
        this.queryFactory = new JPAQueryFactory(em);
    }
    
    public List<Student> quertDslTest(){
        List<Student> studentList = queryFactory.select(QStudent.student)
            .from(QStudent.student)
            .fetch();
        return studentList;
    }
    
    
}
