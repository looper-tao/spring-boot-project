package com.boot.learn.service.listener;

import com.boot.learn.listener.event.MyTestEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author: yeguxin
 * @date: 2021/4/20
 * @description:
 */
@Service
public class TestListenerService {
    private final ApplicationContext context;
    
    @Autowired
    public TestListenerService(ApplicationContext context) {
        this.context = context;
    }
    
    public void testListener(){
        System.out.println("创建监听的事件");
        
        MyTestEvent event = new MyTestEvent(this,"测试监听事件");
        context.publishEvent(event);
    }
}
