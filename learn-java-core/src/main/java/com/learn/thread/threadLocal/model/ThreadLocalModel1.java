package com.learn.thread.threadLocal.model;

/**
 * @author: yeguxin
 * @date: 2021/3/8
 * @description:
 */
public class ThreadLocalModel1 {
    public Byte[] bytes = new Byte[1024 * 1024 * 10];
    
    @Override
    protected void finalize() throws Throwable {
        System.out.println("该对象即将回收");
        super.finalize();
    }
}
