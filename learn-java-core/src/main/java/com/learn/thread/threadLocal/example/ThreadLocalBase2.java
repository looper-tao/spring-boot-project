package com.learn.thread.threadLocal.example;

import com.learn.thread.threadLocal.model.ThreadLocalModel3;

/**
 * @author: yeguxin
 * @date: 2021/3/22
 * @description:
 */
public class ThreadLocalBase2 {
    private static final ThreadLocal<ThreadLocalModel3> threadLocal = new ThreadLocal<ThreadLocalModel3>() {
        @Override
        protected ThreadLocalModel3 initialValue() {
            return new ThreadLocalModel3();
        }
    };
    
    public void setId(Integer id) {
        threadLocal.get().setId(id);
    }
    
    public void setTitle(String title) {
        threadLocal.get().setTitle(title);
    }
    
    public void setContext(String context) {
        threadLocal.get().setContext(context);
    }
    
    public ThreadLocalModel3 get() {
        ThreadLocalModel3 localModel3 = threadLocal.get();
        System.out.println(localModel3.toString());
        return localModel3;
    }
}
