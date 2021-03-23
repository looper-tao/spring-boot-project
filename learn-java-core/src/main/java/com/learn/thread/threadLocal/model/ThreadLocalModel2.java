package com.learn.thread.threadLocal.model;

import lombok.Data;

/**
 * @author: yeguxin
 * @date: 2021/3/22
 * @description:
 */
@Data
public class ThreadLocalModel2 {
    private Integer id;
    
    private String name;
    
    private String desc;
    
    private byte[] bytes;
    
    @Override
    public String toString() {
        return "ThreadLocalModel2{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", desc='" + desc + '\'' +
            '}';
    }
}
