package com.boot.plus.mybatis.service;

import com.baomidou.mybatisplus.service.IService;
import com.boot.plus.mybatis.entity.TPerson;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PersonService extends IService<TPerson> {
    public List<TPerson> selectAll();
}
