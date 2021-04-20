package com.boot.learn.listener.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author: yeguxin
 * @date: 2021/4/20
 * @description:
 */
public class MyTestEvent extends ApplicationEvent {
    private String name;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public MyTestEvent(Object source, String name) {
        super(source);
        this.name = name;
    }
}
