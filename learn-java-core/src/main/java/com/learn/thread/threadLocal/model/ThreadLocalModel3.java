package com.learn.thread.threadLocal.model;

import lombok.Data;

/**
 * @author: yeguxin
 * @date: 2021/3/22
 * @description:
 */

@Data
public class ThreadLocalModel3 {
    private Integer id;
    
    private String title;
    
    private String context;
    
    @Override
    public String toString() {
        return "ThreadLocalModel3{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", context='" + context + '\'' +
            '}';
    }
}
