package com.boot.plus.mybatis.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.boot.plus.mybatis.entity.TPerson;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TPersonMapper extends BaseMapper<TPerson> {
    int deleteByPrimaryKey(Long id);

    TPerson selectByPrimaryKey(Long id);

    List<TPerson> selectAll();

    int updateByPrimaryKey(TPerson record);
}