package com.boot.learn.repository;

import com.boot.learn.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: taozhengzhi
 * @Date: 2019/4/12 下午3:04
 * @Version 1.0
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
