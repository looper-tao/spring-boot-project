package com.learn.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: yeguxin
 * @date: 2020/12/10
 * @description:
 */
public class CglibProxy implements MethodInterceptor {
    /**
     * 需要代理的目标对象
     */
    private Object target;
    
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        method.invoke(target,objects);
        after();
        return null;
    }
    
    private void before(){
        System.out.println("---------前置准备---------");
    }
    
    private void after(){
        System.out.println("---------后置动作---------");
    }
    
    
    public Object getCglibProxy(Object targetObject){
        this.target = targetObject;
        Enhancer enhancer = new Enhancer();
        // 设置父类,因为Cglib是针对指定的类生成一个子类.需要指定父类
        enhancer.setSuperclass(targetObject.getClass());
        // 设置回调
        enhancer.setCallback(this);
        // 创建并返回CglibProxy对象
        return enhancer.create();
    }
}
