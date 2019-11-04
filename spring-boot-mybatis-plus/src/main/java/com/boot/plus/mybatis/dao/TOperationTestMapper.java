package com.boot.plus.mybatis.dao;

import com.boot.plus.mybatis.entity.TOperationTest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TOperationTestMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TOperationTest record);

    TOperationTest selectByPrimaryKey(Long id);

    List<TOperationTest> selectAll();

    int updateByPrimaryKey(TOperationTest record);
}