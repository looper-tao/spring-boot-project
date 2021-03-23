package com.learn.thread.threadLocal.example;

import com.learn.thread.threadLocal.model.ThreadLocalModel2;
import org.springframework.beans.BeanUtils;

/**
 * @author: yeguxin
 * @date: 2021/3/22
 * @description:
 */
public class ThreadLocalBase1 {
    private static final ThreadLocal<ThreadLocalModel2> threadLocal = new ThreadLocal<ThreadLocalModel2>() {
        @Override
        protected ThreadLocalModel2 initialValue() {
            return new ThreadLocalModel2();
        }
    };
    
    public void setId(Integer id) {
        threadLocal.get().setId(id);
    }
    
    public void setName(String name) {
        threadLocal.get().setName(name);
    }
    
    public void setDesc(String desc) {
        threadLocal.get().setDesc(desc);
    }
    
    public void setBytes(byte[] bytes){
        threadLocal.get().setBytes(bytes);
    }
    
    public ThreadLocalModel2 get() {
        ThreadLocalModel2 localModel2 = threadLocal.get();
        System.out.println(localModel2.toString());
        return localModel2;
    }
}
