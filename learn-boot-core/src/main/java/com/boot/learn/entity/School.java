package com.boot.learn.entity;

import com.boot.learn.entity.base.PkNativeID;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: taozhengzhi
 * @Date: 2019/4/12 下午3:17
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "t_school")
public class School extends PkNativeID {
    @Column(name = "name",nullable = false)
    private String name;
    
    @Column(name="address")
    private String address;
    
    @Column(name = "create_at")
    private Date createAt;
}
