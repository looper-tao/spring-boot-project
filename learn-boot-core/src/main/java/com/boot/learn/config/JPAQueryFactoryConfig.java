package com.boot.learn.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

/**
 * @Author: taozhengzhi
 * @Date: 2019/4/15 下午5:42
 * @Version 1.0
 */

@Configuration
public class JPAQueryFactoryConfig {
    
    @Bean
    public JPAQueryFactory jPAQueryFactory(EntityManager em) {
        return new JPAQueryFactory(em);
    }
    
}
