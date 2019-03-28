package com.boot.learn.entity.base;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 统一定义使用数据库Native方法管理主键的entity基类.
 * 对于 oracle 采用Sequence(Hibernate_Sequence)方式
 * 对于 MySQL 和 SQL Server 采用identity(自增主键)
 *
 * @author TrueOrFalse.Yuan
 */
@MappedSuperclass
public abstract class PkNativeID implements Identifiable<Long> {
    
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "db-native")
    @GenericGenerator(name = "db-native", strategy = "native")
    @Getter
    @Setter
    protected Long id;
    
}