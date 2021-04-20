package com.boot.learn.listener;

import com.boot.learn.listener.event.MyTestEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author: yeguxin
 * @date: 2021/4/20
 * @description:
 */
@Component
public class MyTestEventListener implements ApplicationListener<MyTestEvent> {
    @Override
    public void onApplicationEvent(MyTestEvent myTestEvent) {
        String name = myTestEvent.getName();
        System.out.println("开始进行处理监听的事件!   name = " + name);
    }
}
