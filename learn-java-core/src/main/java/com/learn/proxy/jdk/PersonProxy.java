package com.learn.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: yeguxin
 * @date: 2020/12/9
 * @description:
 */
public class PersonProxy implements InvocationHandler {
    /**
     * 目标对象
     */
    private Object target;
    
    public PersonProxy(Object target) {
        this.target = target;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        method.invoke(target,args);
        after();
        return null;
    }
    
    private void before(){
        System.out.println("---------前置准备---------");
    }
    
    private void after(){
        System.out.println("---------后置动作---------");
    }
    
    
}
