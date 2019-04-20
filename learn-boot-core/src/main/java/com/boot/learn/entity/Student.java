package com.boot.learn.entity;

import com.boot.learn.entity.base.PkNativeID;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: taozhengzhi
 * @Date: 2019/4/11 下午8:17
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "t_person")
public class Student extends PkNativeID {
    @Column(name = "school_id",nullable = false)
    private Long schoolId;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "age")
    private Integer age;
    
    @Column(name = "birthday")
    private Date birthday;
    
    @Column(name = "remark")
    private String reamrk;
    
    @Column(name = "score")
    private Integer score;
    
    @Column(name = "create_at")
    private Date createAt;
}
