package com.boot.learn.entity;

import com.boot.learn.entity.base.PkNativeID;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "t_operation_test")
public class OperationTest extends PkNativeID {
    @Column(name = "operation_name")
    private String name;
    
    @Column(name = "remark")
    private String remark;
    
    @Column(name = "create_at")
    private Date createAt;
}
