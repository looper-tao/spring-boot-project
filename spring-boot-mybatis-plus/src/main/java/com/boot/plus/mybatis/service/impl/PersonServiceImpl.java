package com.boot.plus.mybatis.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.boot.plus.mybatis.dao.TPersonMapper;
import com.boot.plus.mybatis.entity.TPerson;
import com.boot.plus.mybatis.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yeguxin
 * @date: 2019/9/26
 * @description:
 */
@Service
public class PersonServiceImpl extends ServiceImpl<TPersonMapper, TPerson> implements PersonService {

    @Override
    public List<TPerson> selectAll(){
        return baseMapper.selectAll();
    }
}
