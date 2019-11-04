package com.boot.plus.mybatis.dao;

import com.boot.plus.mybatis.entity.TSchool;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TSchoolMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TSchool record);

    TSchool selectByPrimaryKey(Long id);

    @Select(value = "select * from t_school")
    List<TSchool> selectAll();

    int updateByPrimaryKey(TSchool record);
}